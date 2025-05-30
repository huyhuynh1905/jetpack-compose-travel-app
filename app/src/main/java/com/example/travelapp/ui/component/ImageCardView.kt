package com.example.travelapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import coil3.compose.AsyncImage
import com.example.travelapp.utils.extension.customClickable
import com.example.travelapp.utils.resource.Dimens

@Composable
fun ImageCardView(
    model: String,
    contentDescription: String,
    height: Dp? = null,
    width: Dp? = null,
    elevation: Dp = Dimens.zero,
    onClick: () -> Unit = {},
    tag: String? = null,
    distance: String? = null,
    contentScale: ContentScale = ContentScale.Fit
){
    Box(
        modifier = Modifier
            .then(
                if (height != null) Modifier.height(height) else Modifier.wrapContentHeight()
            )
            .then(
                if (width != null) Modifier.width(width) else Modifier.fillMaxWidth()
            )
            .clip(RoundedCornerShape(Dimens.radiusNormal))
            .shadow(
                elevation = elevation,
                shape = RoundedCornerShape(Dimens.radiusNormal)
            )
            .background(MaterialTheme.colorScheme.primary)
            .customClickable(
                onClick = onClick,
            )
    ) {
        AsyncImage(
            model = model,
            contentDescription = contentDescription,
            contentScale = contentScale,
            modifier = Modifier.fillMaxWidth()
        )
        if(contentDescription.isNotBlank()) Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(Dimens.pdNormal)
        ) {
            Text(
                text = contentDescription,
                style = MaterialTheme.typography.labelMedium.copy(
                    color = Color.White,
                )
            )
            if(!tag.isNullOrBlank() && !distance.isNullOrBlank()) Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = MaterialTheme.typography.bodySmall.toSpanStyle().copy(
                            color = Color.Yellow
                        )
                    ){
                        append("$tag, ")
                    }
                    withStyle(
                        style = MaterialTheme.typography.bodySmall.toSpanStyle().copy(
                            color = Color.White
                        )
                    ){
                        append("$distance")
                    }

                },
                color = Color.Green
            )
        }
    }
}


@Pixel6APreview
@Composable
fun ImageCardViewPreview(){
    PreviewNoStatusBar {
        ImageCardView(
            model = "https://hotelnikkohanoi.com.vn/wp-content/uploads/2023/05/co-do-hue-dia-diem-chup-anh-dep-o-hue.jpeg",
            contentDescription = "Dai Noi, Hue",
            tag = "#place",
            distance = "10km"
        )
    }
}