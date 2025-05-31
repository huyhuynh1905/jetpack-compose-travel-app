package com.example.travelapp.utils.extension

import androidx.compose.animation.core.copy
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ripple
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role

// Giả sử bạn đang dùng Material 3 ripple, nếu dùng M2 thì đổi import
// và có thể cần androidx.compose.material.ripple.rememberRipple()
// Nếu bạn muốn ripple color là tham số
fun Modifier.customClickable(
    rippleColor: Color = Color.White.copy(alpha = 0.1f), // Giá trị mặc định
    onClick: () -> Unit,
    role: Role? = null
): Modifier = composed { // `composed` cho phép sử dụng remember bên trong modifier
    clickable(
        onClick = onClick,
        indication = ripple(
            color = rippleColor
        ),
        interactionSource = remember { MutableInteractionSource() }
    )
}