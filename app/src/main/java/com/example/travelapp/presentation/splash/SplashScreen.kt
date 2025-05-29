package com.example.travelapp.presentation.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.travelapp.R
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.ui.component.ButtonComponent
import com.example.travelapp.ui.navigation.ScreenNames


@Composable
fun SplashScreen(navController: NavController) {
    // LaunchedEffect sẽ chạy coroutine khi Composable được đưa vào cây UI lần đầu tiên
    // và sẽ bị hủy khi Composable bị loại bỏ.
    // `true` làm key có nghĩa là hiệu ứng này chỉ chạy một lần.
    BaseScreen(viewModel = viewModel<SplashViewModel>()) {
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Column {
                    ButtonComponent(
                        text = "To Sample Screen",
                        onClick = {
                            navController.navigate(ScreenNames.SAMPLE_SCREEN)
                        },
                    )
                    ButtonComponent(
                        text = "Click Button",
                        onClick = {

                        },
                        idIcon = R.drawable.ic_add

                    )
                    Text("Loading...", style = MaterialTheme.typography.headlineMedium)
                }
                // Bạn có thể thêm logo hoặc hình ảnh khác ở đây
            }
        }
    }

}

