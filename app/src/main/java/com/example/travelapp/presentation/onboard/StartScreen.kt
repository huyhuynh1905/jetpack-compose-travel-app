package com.example.travelapp.presentation.onboard

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import com.example.travelapp.R
import com.example.travelapp.ui.component.ButtonComponent
import com.example.travelapp.ui.navigation.ScreenNames
import com.example.travelapp.utils.resource.Dimens

@Composable
fun StartScreen(nav: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        ChangeStatusBarColor()

        Image(
            painter = painterResource(id = R.drawable.img_onboard4),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.pdNormal),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.travel_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(
                            top = Dimens.statusBarHeight + Dimens.pdLargest,
                            bottom = Dimens.pdNormal
                        )
                        .size(Dimens.logoSize)
                )
                Spacer(Modifier.height(Dimens.pdNormal))
                Text(
                    text = stringResource(R.string.wellcome_travel_app),
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = Color.White
                    ),
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(Dimens.pdNormal))
                Text(
                    text = stringResource(R.string.start_des_travel_app),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.White
                    ),
                    textAlign = TextAlign.Center
                )
            }

            ButtonComponent(
                text = "Get Started",
                marginVer = Dimens.pdLargest+Dimens.statusBarHeight,
                onClick = {
                    nav.navigate(ScreenNames.ONBOARD_SCREEN)
                }
            )
        }

    }
}

@Composable
fun ChangeStatusBarColor() {
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
        insetsController.isAppearanceLightStatusBars = false

        // (Tùy chọn) Đảm bảo layout không bị vẽ dưới status bar nếu cần
        // WindowCompat.setDecorFitsSystemWindows(window, false) // Nếu bạn muốn nội dung tràn ra sau status bar
    }

    // Quan trọng: Khôi phục lại màu status bar gốc khi Composable này bị hủy
    // Hoặc khi Activity/Fragment chứa nó bị hủy.
    // DisposableEffect là lựa chọn tốt hơn cho việc này nếu bạn muốn hành động này chỉ xảy ra
    // khi composable được thêm vào hoặc loại bỏ khỏi composition.
    DisposableEffect(Unit) {
        onDispose {
            val window = (view.context as? Activity)?.window
            window?.let {
                it.statusBarColor = originalStatusBarColor ?: Color.Transparent.toArgb() // Hoặc màu mặc định của theme
                // Khôi phục lại isAppearanceLightStatusBars nếu bạn biết trạng thái trước đó
                // Ví dụ: nếu theme mặc định của bạn dùng icon sáng:
                WindowInsetsControllerCompat(it, view).isAppearanceLightStatusBars = true
            }
        }
    }
}
