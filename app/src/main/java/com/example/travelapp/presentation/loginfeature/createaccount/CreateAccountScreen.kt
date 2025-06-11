package com.example.travelapp.presentation.loginfeature.createaccount

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travelapp.R
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.presentation.loginfeature.createaccount.support.DialogDisplayState
import com.example.travelapp.presentation.loginfeature.createaccount.support.DialogScreenEvent
import com.example.travelapp.ui.component.AppBarComponent
import com.example.travelapp.ui.component.ButtonComponent
import com.example.travelapp.ui.component.ChangeStatusBarColor
import com.example.travelapp.ui.component.DialogComponent
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

    BaseScreen(
        viewModel = hiltViewModel<CreateAccountViewModel>(),
        isSafeArea = false,
        background = Color.White
    ) { viewModel ->

        var fullname by rememberSaveable { mutableStateOf("") }
        var emailAdrress by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }

        val eventDialogState by viewModel.dialogState.collectAsState()
        val localContext = LocalContext.current

        Box(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()
        ) {
            Column {
                AppBarComponent(
                    title = "",
                    navController = nav!!
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(
                            top = Dimens.pdNormal,
                            start = Dimens.pdLarge,
                            end = Dimens.pdLarge
                        )
                        .verticalScroll(rememberScrollState())
                ) {
                    //phần hiển thị thông tin
                    Spacer(modifier = Modifier.height(Dimens.pdBig))
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
                Box(
                    modifier = Modifier
                        .padding(
                            top = Dimens.pdNormal,
                            start = Dimens.pdLarge,
                            end = Dimens.pdLarge,
                            bottom = Dimens.pdNormal,
                        )
                ) {
                    ButtonComponent(
                        text = stringResource(id = R.string.create_account_des),
                        onClick = {
                            viewModel.createAccountAction(
                                fullname,
                                emailAdrress,
                                password,
                                onSucces = {
                                    if (fullname.isNotBlank() && emailAdrress.isNotBlank() && password.isNotBlank()) {
                                        nav.navigate(ScreenNames.VERIFY_ACC_SCREEN)
                                    } else {
                                        viewModel.onEvent(
                                            DialogScreenEvent.ShowDialogButtonClicked(
                                                title = localContext.getString(R.string.message),
                                                message = localContext.getString(R.string.please_input_your_infomation)
                                            )
                                        )
                                    }

                                }
                            )
                        }
                    )
                }
                Spacer(modifier = Modifier.height(Dimens.pdSmaller + Dimens.navSysBarHeight))
            }
        }

        ///handler dialog
        when(val state = eventDialogState){
            is DialogDisplayState.Hidden -> {

            }
            is DialogDisplayState.Showing -> {
                // Hiển thị dialog
                DialogComponent(
                    showDialog = true,
                    title = state.title,
                    message = state.message,
                    onDismiss = {
                        viewModel.onEvent(DialogScreenEvent.DismissDialog)
                    },
                )
            }
        }
    }
}



@Pixel6APreview
@Composable
fun AddAccountScreenPreview() {
    CreateAccountScreen()
}