package com.example.travelapp.ui.component

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowInsetsControllerCompat

@Composable
fun ChangeStatusBarColor(
    isAppearanceLightStatusBars: Boolean = false,
    isDisposableEffectRun: Boolean = false,
) {
    val view = LocalView.current
    val originalStatusBarColor = (view.context as? Activity)?.window?.statusBarColor // Nhớ màu gốc để khôi phục
    // SideEffect sẽ chạy sau mỗi lần recomposition thành công
    // Nếu bạn chỉ muốn nó chạy một lần khi vào và khôi phục khi ra, hãy xem DisposableEffect
    SideEffect {
        val window = (view.context as? Activity)?.window ?: return@SideEffect

        // 1. Đặt màu nền cho status bar
        window.statusBarColor = Color.Transparent.toArgb()

        // 2. Đặt màu cho icon và text của status bar
        // WindowCompat.getInsetsController(window, view) cũng có thể dùng nhưng
        // WindowInsetsControllerCompat được khuyến nghị cho tính tương thích
        val insetsController = WindowInsetsControllerCompat(window, view)
        insetsController.isAppearanceLightStatusBars = isAppearanceLightStatusBars

        // (Tùy chọn) Đảm bảo layout không bị vẽ dưới status bar nếu cần
        // WindowCompat.setDecorFitsSystemWindows(window, false) // Nếu bạn muốn nội dung tràn ra sau status bar
    }

    // Quan trọng: Khôi phục lại màu status bar gốc khi Composable này bị hủy
    // Hoặc khi Activity/Fragment chứa nó bị hủy.
    // DisposableEffect là lựa chọn tốt hơn cho việc này nếu bạn muốn hành động này chỉ xảy ra
    // khi composable được thêm vào hoặc loại bỏ khỏi composition.
    if(isDisposableEffectRun) DisposableEffect(Unit) {
        onDispose {
            val window = (view.context as? Activity)?.window
            window?.let {
                it.statusBarColor = originalStatusBarColor ?: Color.Transparent.toArgb() // Hoặc màu mặc định của theme
                // Khôi phục lại isAppearanceLightStatusBars nếu bạn biết trạng thái trước đó
                // Ví dụ: nếu theme mặc định của bạn dùng icon sáng:
                WindowInsetsControllerCompat(it, view).isAppearanceLightStatusBars = !isAppearanceLightStatusBars
            }
        }
    }
}