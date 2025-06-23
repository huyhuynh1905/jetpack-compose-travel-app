package com.example.travelapp.presentation.mainfeature.homescreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.presentation.mainfeature.homescreen.widget.InfoHeader
import com.example.travelapp.presentation.mainfeature.homescreen.widget.TagFilter
import com.example.travelapp.presentation.mainfeature.homescreen.widget.TopAnimationView
import com.example.travelapp.ui.component.Pixel6APreview
import com.example.travelapp.ui.component.PreviewNoPaddingStatusBar

@Composable
fun HomeScreen(){
    BaseScreen(
        viewModel = hiltViewModel<HomeViewModel>(),
        isSafeArea = false,
        background = Color.White
    ) { viewModel->
        var isPanelVisible by remember { mutableStateOf(false) }

        val accountModel by viewModel.accountModel.collectAsState()
        val tagList by viewModel.tagList.collectAsState()

        Column {
            AnimatedVisibility(
                visible = isPanelVisible,
                enter = slideInVertically(
                    initialOffsetY = { -it }, // từ trên trượt xuống
                    animationSpec = tween(durationMillis = 200)
                ),
                exit = slideOutVertically(
                    targetOffsetY = { -it }, // trượt lên trên khi ẩn
                    animationSpec = tween(durationMillis = 200)
                )
            ) {
                TopAnimationView(
                    close = {
                        isPanelVisible = false
                    }
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                InfoHeader(
                    accountModel = accountModel,
                    isPanelVisible = isPanelVisible,
                    expand = {
                        isPanelVisible = !isPanelVisible
                    }
                )
                TagFilter(
                    tagList = tagList,
                    onClick = { item ->
                        viewModel.selectedItemTagfFilter(item)
                    }
                )
            }

        }
    }
}




@Pixel6APreview
@Composable
fun HomeScreePreView(){
    PreviewNoPaddingStatusBar {
        BaseScreen(
            viewModel = hiltViewModel<HomeViewModel>(),
            isSafeArea = false,
            background = Color.White
        ) { viewModel ->
            val tagList by viewModel.tagList.collectAsState()
            TagFilter(tagList = tagList, onClick = {item ->

            })
        }
    }
}