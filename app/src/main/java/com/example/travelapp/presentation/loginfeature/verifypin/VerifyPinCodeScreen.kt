package com.example.travelapp.presentation.loginfeature.verifypin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travelapp.R
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.ui.component.AppBarComponent
import com.example.travelapp.ui.component.ButtonComponent
import com.example.travelapp.ui.component.OtpInputField
import com.example.travelapp.ui.component.Pixel6APreview
import com.example.travelapp.ui.navigation.LocalNavController
import com.example.travelapp.ui.themes.gray
import com.example.travelapp.ui.themes.redBg
import com.example.travelapp.ui.themes.yellowOr
import com.example.travelapp.utils.extension.bottomStroke
import com.example.travelapp.utils.resource.Dimens

@Composable
fun VerifyPinCodeScreen() {
    val nav = LocalNavController.current
    BaseScreen(
        viewModel = hiltViewModel<VerifyPinCodeViewModel>(),
        background = Color.White,
        isSafeArea = false
    ) { viewModel ->

        val otpValue = remember { mutableStateOf("") }

        Column{
            AppBarComponent(
                title = "",
                navController = nav!!
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        vertical = Dimens.pdNormal,
                        horizontal = Dimens.pdLarge
                    )
                    .imePadding()
            ) {
                //phần hiển thị thông tin
                Spacer(modifier = Modifier.height(Dimens.pdBig))
                Image(
                    painter = painterResource(id = R.drawable.ic_key_a),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.height(Dimens.pdNormal))
                Text(
                    text = stringResource(id = R.string.verify_account),
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = yellowOr,
                        fontSize = Dimens.textSizeSpecialLarge
                    )
                )
                Spacer(modifier = Modifier.height(Dimens.pdNormal))
                //
                val richText = contentRichText()
                ClickableText(
                    text = richText,
                    onClick = { offset ->
                        richText.getStringAnnotations(
                            tag = "ACTION_RESEND",
                            start = offset,
                            end = offset
                        ).firstOrNull()?.let {
                            viewModel.showLog("ClickableText ACTION_RESEND")
                            otpValue.value = ""
                        }
                    }
                )
                Spacer(modifier = Modifier.height(Dimens.pdLarger))

                //nội dung
                Column(
                    modifier = Modifier
                        .weight(1f)
                ) {

                    OtpInputField(
                        otp = otpValue,
                        count = 4,
                        otpBoxModifier = Modifier
                            .bottomStroke(color = Color.DarkGray),
                        otpTextType = KeyboardType.Number
                    )
                }

                ButtonComponent(
                    text = "Verify",
                    onClick = {

                    }
                )
                Spacer(modifier = Modifier.height(Dimens.pdSmaller))
            }
        }
    }
}

@Composable
fun contentRichText() : AnnotatedString {
    val annotatedClickableString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = gray,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = Dimens.textSizeNormal
            )
        ) {
            append(stringResource(R.string.phone_number_pin_des))
        }


        pushStringAnnotation(tag = "ACTION_RESEND", annotation = "resend_code")
        withStyle(
            style = SpanStyle(
                color = redBg,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = Dimens.textSizeNormal
            )
        ) {
            append(" ${stringResource(R.string.resend)}")
        }
        pop() // Kết thúc annotation ACTION_RESEND
    }
    return annotatedClickableString
}


@Pixel6APreview
@Composable
fun VerifyPinCodeScreenPreview() {
    VerifyPinCodeScreen()
}