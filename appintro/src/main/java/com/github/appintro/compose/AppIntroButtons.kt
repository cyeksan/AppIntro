package com.github.appintro.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AppIntroButtons(
    navController: NavController,
    skipButtonName: String,
    nextButtonName: String,
    fontFamily: FontFamily,
    buttonColor: Color,
    skipTo: String,
    nextOnClick: () -> Unit,
    arrowDrawableId: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(24.dp, 16.dp, 24.dp, 48.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {

        Text(
            text = skipButtonName,
            Modifier.clickable {
                navController.popBackStack()
                navController.navigate(skipTo)
            },
            color = buttonColor,
            fontFamily = fontFamily,
            fontSize = 18.sp
        )
        Row(modifier = Modifier.wrapContentSize()) {
            Text(
                text = nextButtonName,
                Modifier.clickable {

                    nextOnClick()
                },
                color = buttonColor,
                fontFamily = fontFamily,
                fontSize = 18.sp
            )
            if(arrowDrawableId != 0) {
                Image(
                    painter = painterResource(id = arrowDrawableId),
                    contentDescription = "next arrow",
                    colorFilter = ColorFilter.tint(buttonColor)
                )
            }

        }

    }

}