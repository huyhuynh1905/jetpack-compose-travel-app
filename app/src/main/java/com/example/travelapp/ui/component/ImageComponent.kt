package com.example.travelapp.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import com.example.travelapp.R
import com.example.travelapp.ui.themes.blueFb
import com.example.travelapp.ui.themes.redBg
import com.example.travelapp.utils.resource.Dimens
import com.spr.jetpack_loading.components.indicators.LineSpinFadeLoaderIndicator

@Composable
fun ImageComponent(
    model: Any?,
    contentDescription: String?,
    contentScale: ContentScale = ContentScale.Crop,
    painterError: Int = R.drawable.img_default_image,
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier
) {
    val painter = rememberAsyncImagePainter(model = model)
    val state = painter.state.collectAsState().value

    val displayPainter = when (state) {
        is AsyncImagePainter.State.Loading,
        is AsyncImagePainter.State.Error -> painterResource(id = painterError)
        else -> painter
    }

    val paddingContent = when (state) {
        is AsyncImagePainter.State.Loading,
        is AsyncImagePainter.State.Error -> Dimens.pdSmall
        else -> Dimens.zero
    }

    val contentScaleByState = when (state) {
        is AsyncImagePainter.State.Error -> ContentScale.Inside
        else -> contentScale
    }

    when(state){
        is AsyncImagePainter.State.Loading -> {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(blueFb.copy(alpha = 0.05f)),
                contentAlignment = Alignment.Center,
            ) {
                LineSpinFadeLoaderIndicator(
                    color = redBg,
                    radius = 25f,
                    penThickness = 10f
                )
            }

        }

        is AsyncImagePainter.State.Error -> {
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .background(blueFb.copy(alpha = 0.05f)),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    painter = displayPainter,
                    contentDescription = contentDescription,
                    contentScale = contentScaleByState,
                    modifier = modifier
                        .padding(paddingContent)
                )
            }
        }

        else -> {
            Image(
                painter = displayPainter,
                contentDescription = contentDescription,
                contentScale = contentScale,
                modifier = modifier
                    .fillMaxSize()
            )
        }
    }


}
