package com.example.travelapp.presentation.sample

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.travelapp.R
import com.example.travelapp.ui.component.ImageCardView
import com.example.travelapp.utils.resource.Dimens

@Composable
fun SampleScreen(navController: NavController){
    Column {
        Conversation(
            listOf(
                Message(
                    "Android1",
                    "Jetpack Compose loremJetpack Compose loremJetpack Compose loremJetpack Compose loremJetpack Compose loremJetpack Compose loremJetpack Compose lorem"
                ),
                Message(
                    "Android2",
                    "Jetpack Composeack Composeack Composeack Composeack Composeack Composeack Compose"
                ),
                Message("Android3", "Jetpack Compose"),
                Message(
                    "Android4",
                    "Jetpack Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose"
                ),
                Message("Android5", "Jetpack Compose"),
            )
        )
        ImageCardView(
            model = "https://hotelnikkohanoi.com.vn/wp-content/uploads/2023/05/co-do-hue-dia-diem-chup-anh-dep-o-hue.jpeg",
            contentDescription = "Dai Noi, Hue",
            tag = "#place",
            distance = "10km"
        )
    }
}


data class Message(val author: String, val body: String)

@Composable
fun Conversation(messages: List<Message>) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding())
    ) {
        LazyColumn {
            items(messages) { message ->
                MessageCard(message)
            }
        }
    }
}


@Composable
fun MessageCard(message: Message){
    Row(modifier = Modifier.padding(Dimens.pdSmall)) {
        Image(
            painter = painterResource(R.drawable.avatar_luffy),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(
                    width = 1.5.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
        )
        Spacer(modifier = Modifier.width(Dimens.pdSmall))
        // We keep track if the message is expanded or not in this
        // variable
        var isExpanded by remember { mutableStateOf(false) }
        // surfaceColor will be updated gradually from one color to the other
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        )

        Column(modifier = Modifier.clickable (
            onClick = {isExpanded = !isExpanded },
            interactionSource = remember { MutableInteractionSource() },
            // Replace rememberRipple with the new ripple API
            indication = ripple(
                color = Color.Red.copy(alpha = 0.1f) // You can still customize the color
            )
        )) {
            Text(
                text = message.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )
            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = Dimens.elevationNormal,
                color = surfaceColor,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = message.body,
                    modifier = Modifier.padding(Dimens.pdSmallest),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}


@Preview(
    showBackground = true, // Hiển thị nền để dễ nhìn
    showSystemUi = true,
    device = Devices.PIXEL_7
)
@Composable
fun PreviewMessageCard(){
    Column {
        Conversation(
            listOf(
                Message(
                    "Android1",
                    "Jetpack Compose loremJetpack Compose loremJetpack Compose loremJetpack Compose loremJetpack Compose loremJetpack Compose loremJetpack Compose lorem"
                ),
                Message(
                    "Android2",
                    "Jetpack Composeack Composeack Composeack Composeack Composeack Composeack Compose"
                ),
                Message("Android3", "Jetpack Compose"),
                Message(
                    "Android4",
                    "Jetpack Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose Compose"
                ),
                Message("Android5", "Jetpack Compose"),
            )
        )
        ImageCardView(
            model = "https://hotelnikkohanoi.com.vn/wp-content/uploads/2023/05/co-do-hue-dia-diem-chup-anh-dep-o-hue.jpeg",
            contentDescription = "Dai Noi, Hue",
            tag = "#place",
            distance = "10km"
        )
    }
}