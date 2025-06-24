package com.example.travelapp.presentation.mainfeature.homescreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.presentation.mainfeature.homescreen.widget.InfoHeader
import com.example.travelapp.presentation.mainfeature.homescreen.widget.PerfectForYou
import com.example.travelapp.presentation.mainfeature.homescreen.widget.TagFilter
import com.example.travelapp.presentation.mainfeature.homescreen.widget.TopAnimationView
import com.example.travelapp.ui.component.ImageCardView
import com.example.travelapp.ui.component.Pixel6APreview
import com.example.travelapp.ui.component.PreviewNoPaddingStatusBar
import com.example.travelapp.ui.themes.redBg
import com.example.travelapp.utils.resource.Dimens

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
        val places by viewModel.placeModels.collectAsState()

        val itemHeights = remember(places) {
            places.map { (150..300).random().dp }
        }

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
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = Dimens.pdNormal,
                horizontalArrangement = Arrangement.spacedBy(Dimens.pdNormal),
                userScrollEnabled = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(
                        start = Dimens.pdMedium,
                        end = Dimens.pdMedium
                    )
            ) {

                item(
                    span = StaggeredGridItemSpan.FullLine
                ) {
                    InfoHeader(
                        accountModel = accountModel,
                        isPanelVisible = isPanelVisible,
                        expand = {
                            isPanelVisible = !isPanelVisible
                        }
                    )
                }

                item(
                    span = StaggeredGridItemSpan.FullLine
                ) {
                    TagFilter(
                        tagList = tagList,
                        onClick = { item ->
                            viewModel.selectedItemTagfFilter(item)
                        }
                    )
                }

                item(
                    span = StaggeredGridItemSpan.FullLine
                ) {
                    Column(
                        modifier = Modifier
                            .padding(
                                top = Dimens.pdMedium,
                            )
                    ) {
                        //Phần title
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text(
                                text = "Perfect for you",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            Text(
                                text = "Filter",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    color = redBg
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(Dimens.pdMedium))


                    }
                }

                items(places.size) { index ->
                    ImageCardView(
                        model = places[index].urlImage,
                        contentDescription = places[index].placeName,
                        height = itemHeights[index],
                        elevation = Dimens.zero,
                        contentScale = ContentScale.Crop,
                        tag = places[index].tagCategory,
                        distance = places[index].distance
                    )
                }
                item(
                    span = StaggeredGridItemSpan.FullLine
                ) {
                    Spacer(
                        modifier = Modifier.height(Dimens.navSysBarHeight)
                    )
                }
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

        }
    }
}