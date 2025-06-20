package com.example.travelapp.presentation.mainfeature.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.travelapp.R
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.domain.model.AccountModel
import com.example.travelapp.ui.component.Pixel6APreview
import com.example.travelapp.ui.component.PreviewNoPaddingStatusBar
import com.example.travelapp.ui.themes.gray
import com.example.travelapp.utils.extension.customClickable
import com.example.travelapp.utils.resource.Dimens

@Composable
fun HomeScreen(){
    BaseScreen(
        viewModel = hiltViewModel<HomeViewModel>(),
        isSafeArea = false,
        background = Color.White
    ) { viewModel->

        val accountModel by viewModel.accountModel.collectAsState()

        Column {
            TopAnimationView()
            InfoHeader(
                accountModel = accountModel
            )
        }
    }
}

@Composable
fun TopAnimationView() {
    Box(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .clip(
            RoundedCornerShape(
                bottomStart = Dimens.homeBarRadius,
                bottomEnd = Dimens.homeBarRadius
            )
        )
        .background(Color.Black)
    ){
        Column {
            //Dấu x
            Box(
                modifier = Modifier.fillMaxWidth()
            ){
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(
                            top = Dimens.statusBarHeight + Dimens.pdMedium,
                            start = Dimens.pdBiger,
                            end = Dimens.pdBiger,
                            bottom = Dimens.pdMedium
                        )
                )
            }

            //item
            LazyVerticalGrid(
                columns = GridCells.Fixed(3), // Hiển thị 3 cột, vì có 6 item sẽ tạo 2 hàng
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(
                        horizontal = Dimens.pdBiger
                    ),
                verticalArrangement = Arrangement.spacedBy(Dimens.pdMedium), // Khoảng cách giữa các hàng
                horizontalArrangement = Arrangement.spacedBy(Dimens.pdMedium) // Khoảng cách giữa các cột
            ) {
                items(listOf(1,2,3,4,5,6)) { itemText ->
                    Box(
                        modifier = Modifier
                            .size(Dimens.sizeMenuBarHome)
                            .background(Color.White)
                    ) {
                        
                    }
                }
            }

            Spacer(modifier = Modifier.height(Dimens.pdBiger))
        }
    }
}


@Composable
fun InfoHeader(accountModel: AccountModel?) {
    Row(
        modifier = Modifier
            .padding(
                horizontal = Dimens.pdMedium,
                vertical = Dimens.pdMedium
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
                    }
                )
        )
    }
}



@Pixel6APreview
@Composable
fun HomeScreePreView(){
    PreviewNoPaddingStatusBar {
        TopAnimationView()
    }
}