package com.example.travelapp.presentation.onboard

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import com.example.travelapp.R
import com.example.travelapp.ui.component.ButtonComponent
import com.example.travelapp.ui.component.ChangeStatusBarColor
import com.example.travelapp.ui.navigation.ScreenNames
import com.example.travelapp.utils.resource.Dimens

@Composable
fun StartScreen(nav: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        ChangeStatusBarColor()

        Image(
            painter = painterResource(id = R.drawable.img_onboard4),
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
                horizontalAlignment = Alignment.CenterHorizontally,
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
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(Dimens.pdNormal))
                Text(
                    text = stringResource(R.string.start_des_travel_app),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.White
                    ),
                    textAlign = TextAlign.Center
                )
            }

            ButtonComponent(
                text = "Get Started",
                marginVer = Dimens.pdLargest+Dimens.statusBarHeight,
                onClick = {
                    nav.navigate(ScreenNames.ONBOARD_SCREEN)
                }
            )
        }

    }
}
