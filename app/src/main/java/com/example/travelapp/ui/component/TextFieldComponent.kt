package com.example.travelapp.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import com.example.travelapp.ui.themes.gray
import com.example.travelapp.ui.themes.redBg
import com.example.travelapp.utils.resource.Dimens

@Composable
fun TextFieldComponent(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    holder: String = "",
    singleLine: Boolean = false,
    isShowBottomLine: Boolean = true,
    imeAction: ImeAction = ImeAction.Next,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType = KeyboardType.Text,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
) {
    var focusTextField by remember { mutableStateOf(false) }

    Column {
        if(label.isNotBlank()) Text(
            text = label,
            style = MaterialTheme.typography.bodySmall
        )
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    focusTextField = focusState.isFocused
                },
            textStyle = MaterialTheme.typography.bodyMedium.copy(
                color = Color.Black,
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = imeAction,
                keyboardType = keyboardType
            ),
            singleLine = singleLine,
            maxLines = maxLines,
            cursorBrush = SolidColor(redBg), // Màu con trỏ
            visualTransformation = visualTransformation, //format pass
            decorationBox = { innerTextField ->
                Column {
                    // Box chứa label và innerTextField để kiểm soát padding
                    Box(
                        modifier = Modifier
                            // Padding ngang = 0dp, padding dọc để có không gian cho label và line
                            .padding(
                                horizontal = Dimens.zero,
                                vertical = Dimens.pdSmall
                            )
                    ) {
                        // Label (hiển thị khi text trống và không focus)
                        if (value.isEmpty() && !focusTextField) {
                            Text(
                                text = holder,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = gray
                                )
                            )
                        }
                        innerTextField() // Đây là vùng nhập liệu thực tế
                    }
                    // Đường line dưới tùy chỉnh
                    val lineColor = gray
                    if(isShowBottomLine) Canvas(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(Dimens.normalLineHeight)
                    ) {
                        val strokeWidth =
                            Dimens.normalLineHeight.toPx() // hoặc Dimens.thinLineHeight.toPx()
                        drawLine(
                            color = lineColor,
                            start = Offset(0f, size.height - strokeWidth / 2),
                            end = Offset(size.width, size.height - strokeWidth / 2),
                            strokeWidth = strokeWidth
                        )
                    }
                }
            }
        )
    }
}