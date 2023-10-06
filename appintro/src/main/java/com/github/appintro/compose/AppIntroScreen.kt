package com.github.appintro.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import com.github.appintro.indicator.compose.DotsIndicator
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, kotlinx.coroutines.InternalCoroutinesApi::class)
@Composable
fun AppIntroScreen(
    navController: NavController,
    lifecycleCoroutineScope: LifecycleCoroutineScope,
    pageNum: Int,
    imageIdList: List<Int> = listOf(0, 0, 0, 0, 0),
    titleList: List<String>,
    descriptionList: List<String>,
    skipTo: String,
    properties: Properties,
) {
    val state = remember { State() }
    val pagerState = rememberPagerState()
    if (pageNum in 3..5) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            HorizontalPager(
                count = pageNum,
                state = pagerState,
                modifier = Modifier.fillMaxHeight(),
            ) { page ->
                when (page) {
                    0 -> setPageValues(
                        0,
                        state,
                        imageIdList,
                        titleList,
                        descriptionList,
                        properties.backgroundColorStartList,
                        properties.backgroundColorEndList,
                        properties.titleColorList,
                        properties.descriptionColorList
                    )

                    1 -> {
                        setPageValues(
                            1,
                            state,
                            imageIdList,
                            titleList,
                            descriptionList,
                            properties.backgroundColorStartList,
                            properties.backgroundColorEndList,
                            properties.titleColorList,
                            properties.descriptionColorList
                        )
                    }

                    2 -> {
                        setPageValues(
                            2,
                            state,
                            imageIdList,
                            titleList,
                            descriptionList,
                            properties.backgroundColorStartList,
                            properties.backgroundColorEndList,
                            properties.titleColorList,
                            properties.descriptionColorList
                        )
                    }

                    3 -> {
                        setPageValues(
                            3,
                            state,
                            imageIdList,
                            titleList,
                            descriptionList,
                            properties.backgroundColorStartList,
                            properties.backgroundColorEndList,
                            properties.titleColorList,
                            properties.descriptionColorList
                        )
                    }

                    4 -> {
                        setPageValues(
                            4,
                            state,
                            imageIdList,
                            titleList,
                            descriptionList,
                            properties.backgroundColorStartList,
                            properties.backgroundColorEndList,
                            properties.titleColorList,
                            properties.descriptionColorList
                        )
                    }
                }
                Column(
                    Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    state.backgroundColorStart,
                                    state.backgroundColorEnd
                                )
                            )
                        ), horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    AppIntroPlaceholderImage(
                        imageId = state.imageId,
                        contentScale = properties.imageContentScale,
                    )
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(16.dp, 0.dp),
                    ) {

                        state.title?.let {
                            state.description?.let { it1 ->
                                AppIntroContent(
                                    title = it,
                                    description = it1,
                                    titleColor = state.titleColor,
                                    descriptionColor = state.descriptionColor,
                                    titleFontSize = properties.titleFontSize,
                                    descriptionFontSize = properties.descriptionFontSize,
                                    titleFontFamily = properties.titleFontFamily,
                                    descriptionFontFamily = properties.descriptionFontFamily
                                )
                            }
                        }

                        DotsIndicator(
                            totalDots = pageNum,
                            selectedIndex = pagerState.currentPage,
                            selectedColor = properties.selectedDotColor,
                            unSelectedColor = properties.unselectedDotColor
                        )
                        Column(
                            Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            AppIntroButtons(
                                navController = navController,
                                skipButtonName = properties.skipButtonName,
                                nextButtonName = properties.nextButtonName,
                                fontFamily = properties.titleFontFamily,
                                buttonColor = properties.buttonColor,
                                skipTo = skipTo,
                                nextOnClick = {
                                    lifecycleCoroutineScope.launch(Dispatchers.Main) {
                                        if (page == pageNum - 1) {
                                            navController.popBackStack()
                                            navController.navigate(skipTo)
                                            return@launch
                                        }
                                        pagerState.scrollToPage(page + 1)

                                    }
                                },
                                arrowDrawableId = properties.nextArrowIconDrawableId
                            )
                        }
                    }
                }
            }
        }
    }
}

fun setPageValues(
    currentPageIndex: Int,
    state: State,
    imageIdList: List<Int>,
    titleList: List<String>,
    descriptionList: List<String>,
    backgroundColorStartList: List<Color>,
    backgroundColorEndList: List<Color>,
    titleColorList: List<Color>,
    descriptionColorList: List<Color>
) {
    state.imageId = imageIdList[currentPageIndex]
    state.title = titleList[currentPageIndex]
    state.description = descriptionList[currentPageIndex]
    state.backgroundColorStart = backgroundColorStartList[currentPageIndex]
    state.backgroundColorEnd = backgroundColorEndList[currentPageIndex]
    state.titleColor = titleColorList[currentPageIndex]
    state.descriptionColor = descriptionColorList[currentPageIndex]
}