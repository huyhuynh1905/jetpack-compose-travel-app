package com.example.travelapp.presentation.loginfeature.createaccount

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travelapp.R
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.ui.component.ButtonComponent
import com.example.travelapp.ui.component.ChangeStatusBarColor
import com.example.travelapp.ui.component.Pixel6APreview
import com.example.travelapp.ui.component.TextFieldComponent
import com.example.travelapp.ui.navigation.LocalNavController
import com.example.travelapp.ui.navigation.ScreenNames
import com.example.travelapp.ui.themes.gray
import com.example.travelapp.ui.themes.yellowOr
import com.example.travelapp.utils.resource.Dimens
import java.util.Locale

@Composable
fun CreateAccountScreen() {
    val nav = LocalNavController.current

    ChangeStatusBarColor(isAppearanceLightStatusBars = true)

    BaseScreen(viewModel = hiltViewModel<CreateAccountViewModel>()) { viewModel ->

        var fullname by remember { mutableStateOf("") }
        var emailAdrress by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = Dimens.pdNormal,
                    horizontal = Dimens.pdLarge
                )
        ){
            //phần hiển thị thông tin
            Spacer(modifier = Modifier.height(Dimens.pdBig*3))
            Image(
                painter = painterResource(id = R.drawable.ic_mess_heart),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(Dimens.pdNormal))
            Text(
                text = stringResource(id = R.string.create_account),
                style = MaterialTheme.typography.titleLarge.copy(
                    color = yellowOr,
                    fontSize = Dimens.textSizeSpecialLarge
                )
            )
            Spacer(modifier = Modifier.height(Dimens.pdNormal))
            Text(
                text = stringResource(id = R.string.des_create_account),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = gray
                )
            )
            Spacer(modifier = Modifier.height(Dimens.pdLarger))
            //nội dung
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                TextFieldComponent(
                    value = fullname,
                    onValueChange = { newValue ->
                        fullname = newValue
                    },
                    label = stringResource(id = R.string.full_name).toUpperCase(Locale.getDefault()),
                    holder = "Alex Chan",
                )
                Spacer(modifier = Modifier.height(Dimens.pdNormal))

                TextFieldComponent(
                    value = emailAdrress,
                    onValueChange = { newValue ->
                        emailAdrress = newValue
                    },
                    label = stringResource(id = R.string.email_address).toUpperCase(Locale.getDefault()),
                    holder = "alex@gmail.com",
                    keyboardType = KeyboardType.Email
                )
                Spacer(modifier = Modifier.height(Dimens.pdNormal))

                TextFieldComponent(
                    value = password,
                    onValueChange = { newValue ->
                        password = newValue
                    },
                    label = stringResource(id = R.string.password).toUpperCase(Locale.getDefault()),
                    holder = stringResource(id = R.string.password),
                    imeAction = ImeAction.Done,
                    visualTransformation = PasswordVisualTransformation()
                )

            }

            //Phần button ở dưới
            ButtonComponent(
                text = stringResource(id = R.string.create_account_des),
                onClick = {
                    viewModel.createAccountAction(
                        fullname,
                        emailAdrress,
                        password,
                        onSucces = {
                            nav?.navigate(ScreenNames.VERIFY_ACC_SCREEN)
                        }
                    )
                }
            )
            Spacer(modifier = Modifier.height(Dimens.pdSmaller))
        }
    }
}



@Pixel6APreview
@Composable
fun AddAccountScreenPreview() {
    CreateAccountScreen()
}