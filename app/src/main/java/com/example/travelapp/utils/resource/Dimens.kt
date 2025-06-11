package com.example.travelapp.utils.resource

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Dimens {
    //pading
    val pdSmallest = 4.dp
    val pdSmaller = 6.dp
    val pdSmall = 8.dp
    val pdNormal = 12.dp
    val pdMedium = 16.dp
    val pdBig = 20.dp
    val pdBiger = 24.dp
    val pdLarge = 26.dp
    val pdLarger = 30.dp
    val pdLargest = 40.dp


    //radius
    val radiusSmall = 8.dp
    val radiusNormal = 12.dp
    val radiusMedium = 16.dp
    val radiusLarge = 24.dp
    val circleRadius = 150.dp

    //text size
    val textSizeSmaller = 10.sp
    val textSizeSmall = 12.sp
    val textSizeNormal = 14.sp
    val textSizeBig = 16.sp
    val textSizeBiger = 18.sp
    val textSizeLarge = 20.sp
    val textSizeLargest = 24.sp
    val textSizeSpecialLarge = 30.sp
    val textSizeSpecialLarger = 35.sp
    val textSizeSpecialLargest = 40.sp

    // Elevation
    val elevationNormal = 1.dp
    val elevationLow = 2.dp
    val elevationMedium = 6.dp
    val elevationHigh = 12.dp


    //size
    val zero = 0.dp
    val normalLineHeight = 1.dp
    val buttonSmallHeight = 50.dp
    val buttonHeight = 70.dp
    val appBarHeight = 40.dp
    val backButtonSize = 20.dp
    val backIconSize = 30.dp
    val flagSize = 30.dp
    val logoSize = 70.dp
    val sizeAvatarLogin = 50.dp
    val sizeAddAccount = 30.dp
    val widthFlagDropdown = 100.dp
    val heightFlagDropdown = 300.dp
    val iconDialogSize = 100.dp


    //diff
    /**
     * Lấy chiều cao của status bar.
     * Hàm này phải được gọi từ bên trong một Composable.
     */
    val statusBarHeight: Dp
        @Composable
        get() = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()


    val navSysBarHeight: Dp
        @Composable
        get() = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()

    val screenWidth: Dp
        @SuppressLint("ConfigurationScreenWidthHeight")
        @Composable
        get() = LocalConfiguration.current.screenWidthDp.dp
}