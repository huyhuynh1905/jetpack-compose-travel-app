package com.example.travelapp.presentation.onboard.page

import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.travelapp.R
import com.example.travelapp.ui.component.ButtonComponent
import com.example.travelapp.utils.extension.customClickable
import com.example.travelapp.utils.resource.Dimens

@Composable
fun PageOnBoardView(
    currentPage: Int,
    idBgk: Int,
    isCurrentSelected: Boolean = false,
    goBack: () -> Unit,
    goNext: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Image(
            painter = painterResource(id = idBgk),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.pdNormal),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = Dimens.pdLargest
                    ),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.travel_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(
                            top = Dimens.statusBarHeight + Dimens.pdLargest,
                            bottom = Dimens.pdNormal
                        )
                        .size(Dimens.logoSize)
                )
                Spacer(Modifier.height(Dimens.pdNormal))
                Text(
                    text = stringResource(R.string.wellcome_travel_app),
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color.White
                    ),
                    textAlign = TextAlign.Start
                )
                Spacer(Modifier.height(Dimens.pdNormal))
                Text(
                    text = stringResource(R.string.start_des_travel_app),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.White
                    ),
                    textAlign = TextAlign.Start
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = Dimens.pdBiger
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .height(Dimens.buttonHeight)
                        .width(Dimens.buttonHeight)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.4f))
                        .customClickable(
                            onClick = {
                                goBack()
                            }
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_next_arrow),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .graphicsLayer {
                                scaleX = -1f // Lật mũi tên lại
                            }
                    )
                }


                ButtonComponent(
                    text = "Next",
                    marginHoz = Dimens.zero,
                    width = Dimens.screenWidth * 0.4f,
                    marginVer = Dimens.pdLargest + Dimens.statusBarHeight,
                    onClick = {
                        goNext(currentPage)
                    }
                )
            }
        }
    }
}