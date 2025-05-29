package com.example.travelapp.presentation.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.ui.navigation.ScreenNames
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController) {
    // LaunchedEffect sẽ chạy coroutine khi Composable được đưa vào cây UI lần đầu tiên
    // và sẽ bị hủy khi Composable bị loại bỏ.
    // `true` làm key có nghĩa là hiệu ứng này chỉ chạy một lần.
    BaseScreen(viewModel = viewModel<SplashViewModel>()) {
        LaunchedEffect(key1 = true) {
            delay(2000L) // Chờ 2 giây (2000 milliseconds)
            navController.navigate(ScreenNames.SAMPLE_SCREEN)
        }

        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text("Loading...", style = MaterialTheme.typography.headlineMedium)
                // Bạn có thể thêm logo hoặc hình ảnh khác ở đây
            }
        }
    }

}

