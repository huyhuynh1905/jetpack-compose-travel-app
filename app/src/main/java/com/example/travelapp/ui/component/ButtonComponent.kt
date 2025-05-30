package com.example.travelapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.travelapp.R
import com.example.travelapp.ui.themes.redBg
import com.example.travelapp.utils.resource.Dimens

@Composable
fun ButtonComponent(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    color: Color = redBg,
    height: Dp = Dimens.buttonHeight,
    idIcon: Int = R.drawable.ic_next_arrow,
    marginHoz: Dp = Dimens.pdNormal,
    marginVer: Dp = Dimens.pdSmall,
) {
    Box(modifier = Modifier.padding(
        horizontal = marginHoz,
        vertical = marginVer
    )) {
        Box(
            modifier = Modifier
                .height(height)
                .fillMaxWidth()
                .background(color = color, shape = CircleShape)
                .clickable(
                    onClick = onClick,
                    role = Role.Button,
                    enabled = enabled,
                    indication = ripple(
                        color = Color.White,
                    ),
                    interactionSource = remember { MutableInteractionSource() }
                )
                .padding(horizontal = Dimens.pdMedium)
        ) {
            Text(
                text = text,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = Dimens.pdLarge),
            )
            Icon(
                painter = painterResource(id = idIcon),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterEnd)
            )

        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.PIXEL_6
)
@Composable
fun ButtonComponentPreView(){
    Column(modifier = Modifier.padding(Dimens.pdMedium)) {
        Spacer(modifier = Modifier.padding(top = Dimens.statusBarHeight))
        ButtonComponent(
            text = "Get Started",
            onClick = {

            },
            enabled = true
        )
    }
}