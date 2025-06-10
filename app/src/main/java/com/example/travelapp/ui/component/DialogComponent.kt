package com.example.travelapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.travelapp.R
import com.example.travelapp.ui.themes.textGray
import com.example.travelapp.utils.resource.Dimens

@Composable
fun DialogComponent(
    showDialog: Boolean,
    title: String = "",
    message: String = "",
    onDismiss: () -> Unit = {},
    onConfirm: () -> Unit = {},
    confirmText: String? = null,
    iconResId: Int? = null,
    dissmissOutSide: Boolean = true
){
    if(showDialog) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(
                dismissOnBackPress = false, //cho phép đóng bằng nút back hệ thống
                dismissOnClickOutside = dissmissOutSide,
                usePlatformDefaultWidth = false //kiểm soát chiều rộng hoàn toàn
            )
        ) {
            Card(
                shape = RoundedCornerShape(Dimens.radiusNormal),
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .wrapContentHeight(),
                elevation = CardDefaults.cardElevation(defaultElevation = Dimens.elevationMedium),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Dimens.pdBig),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(Dimens.pdNormal)
                ) {
                    iconResId?.let {
                        Column {
                            Image(
                                painter = painterResource(id = iconResId),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(Dimens.iconDialogSize),
                                contentScale = ContentScale.Fit
                            )
                            Spacer(modifier = Modifier.height(Dimens.pdNormal))
                        }
                    }
                    //title
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = Dimens.textSizeBiger,
                            textAlign = TextAlign.Center
                        )
                    )
                    //message
                    Text(
                        text = message,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = Dimens.textSizeNormal,
                            color = textGray,
                            textAlign = TextAlign.Center
                        )
                    )

                    Spacer(modifier = Modifier.height(Dimens.pdNormal))

                    //button
                    ButtonComponent(
                        text = confirmText ?: "OK",
                        height = Dimens.buttonSmallHeight,
                        onClick = {
                            onDismiss()
                            onConfirm()
                        }
                    )
                }
            }
        }
    }
}




@Pixel6APreview
@Composable
fun DialogComponentPreview() {
    DialogComponent(
        showDialog = true,
        title = "Giả sử bạn có một hình ảnh",
        message = "Đúng vậy, tạo custom dialog trong Jetpack Compose rất trực tiếp và linh hoạt. Bạn sử dụng Composable Dialog và có thể đặt bất kỳ Composable nào khác làm nội dung bên trong nó, cho phép bạn toàn quyền kiểm soát giao diện và hành vi.Dưới đây là một ví dụ chi tiết hơn về cách tạo một custom dialog trong Jetpack Compose, bao gồm cả việc quản lý trạng thái hiển thị và xử lý tương tác:",
        onDismiss = {},
        onConfirm = {},
        iconResId = R.drawable.ic_mountaint
    )
}