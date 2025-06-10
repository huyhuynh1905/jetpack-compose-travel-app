package com.example.travelapp.utils.extension

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ripple
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

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

/**
 * Creates a Modifier that adds a bottom stroke to a Composable.
 *
 * @param color The color of the stroke.
 * @param strokeWidth The thickness of the stroke.
 * @return A Modifier that draws a bottom stroke.
 */
fun Modifier.bottomStroke(color: Color, strokeWidth: Dp = 2.dp): Modifier = this.then(
    Modifier.drawBehind {
        val strokePx = strokeWidth.toPx()
        // Draw a line at the bottom
        drawLine(
            color = color,
            start = Offset(x = 0f, y = size.height - strokePx / 2),
            end = Offset(x = size.width, y = size.height - strokePx / 2),
            strokeWidth = strokePx
        )
    }
)