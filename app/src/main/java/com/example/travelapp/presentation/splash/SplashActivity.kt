package com.example.travelapp.presentation.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.travelapp.R
import com.example.travelapp.ui.themes.TravelAppTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TravelAppTheme { // Thay thế bằng Theme của bạn
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplashScreenContent()
                }
            }
        }
    }
}

@Composable
fun SplashScreenContent() {
    Box(
        modifier = Modifier.fillMaxSize(), // Box chiếm toàn bộ không gian màn hình
        contentAlignment = Alignment.Center // Căn giữa nội dung bên trong Box
    ) {
        Text(
            text = stringResource(id = R.string.title_activity_splash),
            style = MaterialTheme.typography.headlineMedium // Sử dụng một style chữ từ Theme
        )
    }
}


@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    TravelAppTheme { // Thay thế bằng Theme của bạn để Preview giống nhất
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SplashScreenContent()
        }
    }
}
