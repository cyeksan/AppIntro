package com.github.appintro.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.github.appintro.compose.ui.theme.AppIntroBackgroundColor
import com.github.appintro.compose.ui.theme.AppIntroDefaultHeading
import com.github.appintro.compose.ui.theme.AppIntroDefaultText

@Composable
fun AppIntroContent(
    state: State,
    properties: Properties,
    title: String, description: String, titleColor: Color,
    descriptionColor: Color, titleFontSize: TextUnit,
    descriptionFontSize: TextUnit, titleFontFamily: FontFamily,
    descriptionFontFamily: FontFamily
) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .background(AppIntroBackgroundColor)
            .padding(top = 24.dp, bottom = 90.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .wrapContentHeight(align = Alignment.CenterVertically),
            text = title,
            style = AppIntroDefaultHeading
        )
        Row(
            modifier = Modifier.weight(5f)
            ,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (state.imageId != 0) {
                Image(
                    painter = painterResource(id = state.imageId),
                    contentDescription = "",
                    contentScale = properties.imageContentScale
                )

            }
        }
        Text(
            modifier = Modifier
                .weight(3f)
                .wrapContentHeight(align = Alignment.CenterVertically)
                .padding(16.dp),
            text = description,
           style = AppIntroDefaultText
        )
    }
}

