package com.example.travelapp.presentation.loginfeature.loginsuccess

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travelapp.R
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.ui.component.ButtonComponent
import com.example.travelapp.ui.component.Pixel6APreview
import com.example.travelapp.ui.themes.yelDark
import com.example.travelapp.utils.resource.Dimens

@Composable
fun LoginSuccessScreen() {
    BaseScreen(
        viewModel = hiltViewModel<LoginSuccessViewModel>(),
        background = Color.White,
        isSafeArea = false
    ) { viewModel ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = Dimens.pdNormal,
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.img_yellow_bgk),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                    Image(
                        painter = painterResource(id = R.drawable.img_wave_black),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .offset(y = (2).dp),
                        contentScale = ContentScale.FillWidth
                    )

                    Column {
                        Spacer(modifier = Modifier.height(Dimens.statusBarHeight + Dimens.pdLarge*2))
                        Image(
                            painter = painterResource(id = R.drawable.ic_vali_bag),
                            contentDescription = null,
                            modifier = Modifier
                                .offset(x = -Dimens.pdNormal)
                        )
                        Column(
                            modifier = Modifier
                                .padding(
                                    top = Dimens.pdNormal,
                                    start = Dimens.pdLarge,
                                    end = Dimens.pdLarge
                                )
                        ) {
                            Text(
                                text = stringResource(R.string.logged_in_successfully),
                                style = MaterialTheme.typography.titleLarge.copy(
                                    color = Color.Black,
                                    fontSize = Dimens.textSizeSpecialLarger,
                                    lineHeight = Dimens.textSizeSpecialLargest,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                            Spacer(modifier = Modifier.height(Dimens.pdLarge))
                            Text(
                                text = stringResource(R.string.we_have_prepared_information_for_your_journey),
                                style = MaterialTheme.typography.titleLarge.copy(
                                    color = yelDark,
                                    fontSize = Dimens.textSizeBig,
                                )
                            )
                        }

                    }
                }

                Box(
                    modifier = Modifier
                        .weight(1f)
                ) {

                }

                Box(
                    modifier = Modifier
                        .padding(
                            horizontal = Dimens.pdLarge
                        )
                ) {
                    ButtonComponent(
                        text = stringResource(R.string.start_new_journey),
                        onClick = {

                        }
                    )
                }
                Spacer(modifier = Modifier.height(Dimens.pdSmaller + Dimens.navSysBarHeight))

            }
        }
    }
}


@Pixel6APreview
@Composable
fun LoginSuccessScreenPreview() {
    LoginSuccessScreen()
}