package com.example.travelapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.travelapp.ui.themes.dark
import com.example.travelapp.utils.resource.Dimens


@Composable
fun AppBarComponent(
    title: String = "",
    onBack: (() -> Unit)? = null,
    actions: @Composable (() -> Unit)? = null,
    navigationIcon: @Composable (() -> Unit)? = null,
    backgroundColor: Color = Color.White,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimens.appBarHeight + Dimens.statusBarHeight)
            .background(backgroundColor)
            .padding(top = Dimens.statusBarHeight),
        contentAlignment = Alignment.Center
    ) {
        //phàn bên trái
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = Dimens.pdNormal,
                    vertical = Dimens.pdSmaller
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (navigationIcon != null) {
                navigationIcon()
            } else {
                IconButton(
                    onClick = {
                        if (onBack != null) onBack() else {
                            navController.popBackStack()
                        }
                    },
                    modifier = Modifier
                        .size(Dimens.backButtonSize)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                        contentDescription = "Navigate back", // Mô tả cho accessibility
                        tint = dark
                    )
                }
            }

            //phần giữ layout cân đối cho tiêu đề ở giữa
            Box(
                modifier = Modifier
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
            }

            //phần bên phải
            if (actions != null) {
                actions()
            }
        }

        //phần tiêu đề giữa
        Box(
            modifier = Modifier
                .padding(
                    horizontal = Dimens.pdMedium
                )
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Normal
                ),
                maxLines = 1
            )
        }
    }

}


@Pixel6APreview
@Composable
fun AppBarComponentPreview(){
    PreviewWithStatusBar {
        AppBarComponent(
            title = "Đây là tiêu đề",
            navController = rememberNavController()
        )
    }
}