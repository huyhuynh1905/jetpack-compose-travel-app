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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.travelapp.R
import com.example.travelapp.ui.themes.TravelAppTheme
import kotlinx.coroutines.delay
import android.content.Intent
import com.example.travelapp.presentation.sample.SampleActivity

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
                    val context = LocalContext.current as? ComponentActivity // Ép kiểu an toàn sang ComponentActivity
                    SplashScreen{
                        // Hành động sau khi màn hình chờ kết thúc
                        finish() // Đóng SplashActivity để người dùng không quay lại được
                        context?.let {
                            it.startActivity(Intent(it, SampleActivity::class.java))
                            it.finish()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    // LaunchedEffect sẽ chạy coroutine khi Composable được đưa vào cây UI lần đầu tiên
    // và sẽ bị hủy khi Composable bị loại bỏ.
    // `true` làm key có nghĩa là hiệu ứng này chỉ chạy một lần.
    LaunchedEffect(key1 = true) {
        delay(2000L) // Chờ 2 giây (2000 milliseconds)
        onTimeout()  // Gọi hàm callback để chuyển màn hình
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
