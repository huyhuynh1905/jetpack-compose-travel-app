package com.example.travelapp.presentation.mainfeature.homescreen.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil3.compose.AsyncImage
import com.example.travelapp.R
import com.example.travelapp.domain.model.AccountModel
import com.example.travelapp.ui.themes.gray
import com.example.travelapp.utils.extension.customClickable
import com.example.travelapp.utils.resource.Dimens

@Composable
fun InfoHeader(accountModel: AccountModel?, expand: () -> Unit, isPanelVisible: Boolean) {
    Row(
        modifier = Modifier
            .padding(
                top = if(!isPanelVisible) Dimens.statusBarHeight+Dimens.pdMedium else Dimens.pdMedium,
                start = Dimens.pdMedium,
                end = Dimens.pdMedium,
                bottom = Dimens.pdMedium,
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = accountModel?.avatarUrl,
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.img_default_image),
            error = painterResource(id = R.drawable.img_default_image),
            modifier = Modifier
                .size(Dimens.sizeAvatarAcc)
                .clip(RoundedCornerShape(Dimens.radiusMedium))
                .background(Color.White),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(Dimens.pdMedium))
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = accountModel?.name ?: "",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "Welcome to Caroline",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = gray
                )
            )
        }
        Spacer(modifier = Modifier.width(Dimens.pdNormal))
        Image(
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = null,
            modifier = Modifier
                .size(Dimens.menuSize)
                .customClickable(
                    rippleColor = Color.Red,
                    onClick = {
                        //mở menu
                        expand()
                    }
                )
        )
    }
}