package com.example.travelapp.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.travelapp.R
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.ui.navigation.ScreenNames
import com.example.travelapp.utils.resource.Dimens
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    BaseScreen(viewModel = hiltViewModel<SplashViewModel>()) { viewModel ->
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                if (viewModel.isFirstOpen()) {
                    LaunchedEffect(Unit) {
                        delay(2000)

                        navController.navigate(ScreenNames.START_SCREEN) {
                            // Xóa SplashScreen khỏi backstack
                            popUpTo(ScreenNames.SPLASH_SCREEN) {
                                inclusive = true // Quan trọng: Bao gồm cả SPLASH_SCREEN trong việc xóa
                            }
                            // Tùy chọn: Đảm bảo không tạo nhiều instance của HomeScreen nếu nó đã ở trên cùng
                            launchSingleTop = true
                        }
                    }
                } else {
                    navController.navigate(ScreenNames.SAMPLE_SCREEN) {
                        // Xóa SplashScreen khỏi backstack
                        popUpTo(ScreenNames.SPLASH_SCREEN) {
                            inclusive = true // Quan trọng: Bao gồm cả SPLASH_SCREEN trong việc xóa
                        }
                        // Tùy chọn: Đảm bảo không tạo nhiều instance của HomeScreen nếu nó đã ở trên cùng
                        launchSingleTop = true
                    }
                }
                Image(
                    painter = painterResource(R.drawable.travel_logo),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center)
                        .size(Dimens.logoSize)
                )
            }
        }
    }

}

