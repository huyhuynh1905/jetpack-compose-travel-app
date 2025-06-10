package com.example.travelapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.presentation.loginfeature.addaccount.AddAccountScreen
import com.example.travelapp.presentation.loginfeature.createaccount.CreateAccountScreen
import com.example.travelapp.presentation.loginfeature.selectaccount.SelectAccountScreen
import com.example.travelapp.presentation.loginfeature.verifyaccount.VerifyAccountScreen
import com.example.travelapp.presentation.loginfeature.verifypin.VerifyPinCodeScreen
import com.example.travelapp.presentation.onboard.OnBoardPageMain
import com.example.travelapp.presentation.onboard.StartScreen
import com.example.travelapp.presentation.sample.SampleScreen
import com.example.travelapp.presentation.splash.SplashScreen

val LocalNavController = staticCompositionLocalOf<NavController?> { null }

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(navController = navController, startDestination = ScreenNames.SPLASH_SCREEN) {
            composable(ScreenNames.SPLASH_SCREEN) {
                SplashScreen(navController)
            }
            composable(ScreenNames.START_SCREEN) {
                StartScreen(navController)
            }
            composable(ScreenNames.ONBOARD_SCREEN) {
                OnBoardPageMain(navController)
            }
            composable(ScreenNames.SAMPLE_SCREEN) {
                SampleScreen(navController)
            }
            composable(ScreenNames.SELECT_ACC_SCREEN) {
                SelectAccountScreen(navController)
            }
            composable(ScreenNames.ADD_ACC_SCREEN) {
                AddAccountScreen()
            }
            composable(ScreenNames.CREATE_ACC_SCREEN) {
                CreateAccountScreen()
            }
            composable(ScreenNames.VERIFY_ACC_SCREEN) {
                VerifyAccountScreen()
            }
            composable(ScreenNames.PIN_VERIFY_ACC_SCREEN) {
                VerifyPinCodeScreen()
            }
        }
    }

}