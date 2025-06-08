package com.example.travelapp.presentation.loginfeature.createaccount

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travelapp.R
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.ui.component.ButtonComponent
import com.example.travelapp.ui.component.Pixel6APreview
import com.example.travelapp.ui.component.TextFieldComponent
import com.example.travelapp.ui.themes.gray
import com.example.travelapp.ui.themes.redBg
import com.example.travelapp.ui.themes.yellowOr
import com.example.travelapp.utils.resource.Dimens

@Composable
fun CreateAccountScreen() {
    BaseScreen(viewModel = hiltViewModel<CreateAccountViewModel>()) { viewModel ->

        var fullname by remember { mutableStateOf("") }
        var emailAdrress by remember { mutableStateOf("") }

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
            Text(
                text = stringResource(id = R.string.des_create_account),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = gray
                )
            )
            Spacer(modifier = Modifier.height(Dimens.pdNormal))
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
                    label = stringResource(id = R.string.full_name)
                )
                TextField(
                    value = fullname,
                    onValueChange = { newValue ->
                        fullname = newValue
                    },
                    label = {
                        Text("Enter text")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = Dimens.zero
                        )
                        .drawBehind {
                            val strokeWidth = Dimens.normalLineHeight.toPx()
                            val y = size.height - strokeWidth / 2
                            drawLine(
                                color = gray,
                                start = Offset(0f, y),
                                end = Offset(size.width, y),
                                strokeWidth = strokeWidth
                            )
                    },
                    singleLine = true,
                    colors = TextFieldDefaults.colors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        focusedLabelColor = Color.Black,
                        unfocusedLabelColor = Color.Black,
                        cursorColor = redBg
                    )
                )

                OutlinedTextField(
                    value = emailAdrress,
                    onValueChange = {
                        emailAdrress = it
                    }, // "it" là newText
                    label = { Text("Enter text (Outlined)") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            //Phần button ở dưới
            ButtonComponent(
                text = stringResource(id = R.string.create_account_des),
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
    CreateAccountScreen()
}