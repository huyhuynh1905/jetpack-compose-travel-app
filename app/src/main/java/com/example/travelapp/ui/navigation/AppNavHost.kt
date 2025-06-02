package com.example.travelapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.presentation.onboard.OnBoardPageMain
import com.example.travelapp.presentation.onboard.StartScreen
import com.example.travelapp.presentation.sample.SampleScreen
import com.example.travelapp.presentation.splash.SplashScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenNames.START_SCREEN) {
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
    }
}