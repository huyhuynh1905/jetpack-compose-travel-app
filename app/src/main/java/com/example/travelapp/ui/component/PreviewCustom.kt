package com.example.travelapp.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.travelapp.ui.themes.TravelAppTheme
import com.example.travelapp.utils.resource.Dimens


// Định nghĩa annotation tùy chỉnh của bạn
@Preview(
    name = "Pixel 6 - System UI",
    group = "Device Previews",
    device = Devices.PIXEL_6,
    showSystemUi = true,
    showBackground = true,
)
annotation class Pixel6APreview // Tên annotation của bạn

@Composable
fun PreviewNoStatusBar(
    content: @Composable () -> Unit
){
    TravelAppTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = Dimens.statusBarHeight
                )
        ) {
            content()
        }
    }
}