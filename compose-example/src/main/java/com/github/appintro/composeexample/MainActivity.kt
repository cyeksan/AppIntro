package com.github.appintro.composeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.appintro.compose.AppIntroScreen
import com.github.appintro.compose.Properties
import com.github.appintro.composeexample.ui.theme.AppIntroBackgroundColor
import com.github.appintro.composeexample.ui.theme.UnselectedDot

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.getInsetsController(window, window.decorView).apply {
            systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            hide(WindowInsetsCompat.Type.systemBars())
        }
        super.onCreate(savedInstanceState)
        val imageIdList = listOf(
            R.drawable.ic_slide1,
            R.drawable.ic_slide2,
            R.drawable.ic_slide3,
        )
        val pageNum = 3

        val titleList = listOf(
            "Welcome!",
            "Where does it come from?",
            "Why do we use it?"
        )

        val descriptionList = listOf(
            "This is a demo of the AppIntro library, with a custom background on each slide!",
            "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
            "It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.",
        )
        val titleColorList = listOf(
            Color.White,
            Color.White,
            Color.White
        )

        val descriptionColorList = listOf(
            Color.White,
            Color.White,
            Color.White
        )
        val backgroundColorEndList = listOf(
            AppIntroBackgroundColor,
            Color.Blue,
            Color.DarkGray
        )

        val backgroundColorStartList = listOf(
            AppIntroBackgroundColor,
            Color.Magenta,
            Color.Magenta
        )
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.OnboardingScreen.route
                    ) {

                        composable(
                            route = Screen.OnboardingScreen.route
                        ) {
                            AppIntroScreen(
                                imageIdList = imageIdList,
                                navController = navController,
                                lifecycleCoroutineScope = lifecycleScope,
                                pageNum = pageNum, // It must be between 3 and 5 (both inclusive)
                                titleList = titleList,
                                descriptionList = descriptionList,
                                skipTo = Screen.HomeScreen.route,
                                properties = Properties(
                                    titleColorList = titleColorList,
                                    descriptionColorList = descriptionColorList,
                                    backgroundColorStartList = backgroundColorStartList,
                                    backgroundColorEndList = backgroundColorEndList,
                                    buttonColor = Color.White,
                                    selectedDotColor = Color.White,
                                    unselectedDotColor = UnselectedDot,
                                    imageContentScale = ContentScale.Crop,
                                    titleFontSize = 24.sp,
                                    descriptionFontSize = 16.sp,
                                    titleFontFamily = FontFamily.Default,
                                    descriptionFontFamily = FontFamily.Default,
                                    skipButtonName = "SKIP",
                                    nextButtonName = "NEXT",
                                    nextArrowIconDrawableId = R.drawable.next_arrow
                                )
                            )
                        }
                        composable(
                            route = Screen.HomeScreen.route
                        ) {
                            HomeScreen()
                        }
                    }
                }
            }
        }
    }
}