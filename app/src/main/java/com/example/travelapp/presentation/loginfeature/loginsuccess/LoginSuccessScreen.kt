package com.example.travelapp.presentation.loginfeature.loginsuccess

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.ui.component.Pixel6APreview

@Composable
fun LoginSuccessScreen() {
    BaseScreen(
        viewModel = hiltViewModel<LoginSuccessViewModel>(),
        background = Color.White,
    ) { viewModel ->

    }
}


@Pixel6APreview
@Composable
fun LoginSuccessScreenPreview() {
    LoginSuccessScreen()
}