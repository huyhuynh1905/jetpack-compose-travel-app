package com.example.travelapp.presentation.loginfeature.verifyaccount

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travelapp.R
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.presentation.loginfeature.verifyaccount.support.DropdownCustom
import com.example.travelapp.ui.component.ButtonComponent
import com.example.travelapp.ui.component.Pixel6APreview
import com.example.travelapp.ui.component.TextFieldComponent
import com.example.travelapp.ui.themes.gray
import com.example.travelapp.ui.themes.yellowOr
import com.example.travelapp.utils.extension.PhoneNumberVisualTransformation
import com.example.travelapp.utils.resource.Dimens
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerifyAccountScreen() {
    BaseScreen(viewModel = hiltViewModel<VerifyAccountViewModel>()) { viewModel ->

        var phoneNumber by remember { mutableStateOf("") }
        var expandedLocale by remember { mutableStateOf(false) }

        val listLocale by viewModel.listState.collectAsState()
        val selectedLocale by viewModel.selectState.collectAsState()

        val maxDigits = 10

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = Dimens.pdNormal,
                    horizontal = Dimens.pdLarge,
                )
        ){
            //phần hiển thị thông tin
            Spacer(modifier = Modifier.height(Dimens.pdBig*3))
            Image(
                painter = painterResource(id = R.drawable.ic_phone_verify),
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
            Text(
                text = stringResource(id = R.string.des_verify_account),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = gray
                )
            )
            Spacer(modifier = Modifier.height(Dimens.pdLarger))


            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(id = R.string.phone_number).toUpperCase(Locale.ROOT),
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = gray
                    )
                )
                Spacer(modifier = Modifier.height(Dimens.pdNormal))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DropdownCustom(
                        datas = listLocale,
                        onItemSelected = { item ->
                            viewModel.updateLocaleType(item)
                        },
                        selectData = selectedLocale!!
                    )
                    Spacer(modifier = Modifier.width(Dimens.pdMedium))

                    TextFieldComponent(
                        value = phoneNumber,
                        onValueChange = { newValue ->
                            val digitsOnly = newValue.filter { it.isDigit() }
                            if (digitsOnly.length <= maxDigits) {
                                phoneNumber = digitsOnly
                            }
                        },
                        isShowBottomLine = false,
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Done,
                        holder = stringResource(id = R.string.phone_number),
                        visualTransformation = PhoneNumberVisualTransformation()
                    )
                }
                HorizontalDivider(
                    thickness = Dimens.normalLineHeight,
                    color = gray
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


@Pixel6APreview
@Composable
fun AddAccountScreenPreview() {
    VerifyAccountScreen()
}