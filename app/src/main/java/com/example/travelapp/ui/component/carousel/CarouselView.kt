package com.example.travelapp.ui.component.carousel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.travelapp.ui.component.ImageCardView
import com.example.travelapp.ui.themes.yellowOr
import com.example.travelapp.utils.resource.Dimens
import kotlinx.coroutines.delay

@Composable
fun <T : SupportModel>VerticalCarouselWithIndicator(
    intervalMs: Long = 5000,
    items: List<T> = emptyList(),
) {
    val pageCount = items.size
    val pagerState = rememberPagerState(pageCount = { pageCount })

    // Auto scroll
    LaunchedEffect(Unit) {
        while (true) {
            delay(intervalMs)
            val nextPage = (pagerState.currentPage + 1) % pageCount
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(Dimens.sizeImageBanner)
    ) {
        // Carousel nội dung
        VerticalPager(
            state = pagerState,
            pageSpacing = 16.dp,
            modifier = Modifier
                .fillMaxSize(),
        ) { page ->
            ImageCardView(
                model = items[page].getSupportImage(),
                contentDescription = items[page].getSupportTitle(),
                elevation = Dimens.zero,
                contentScale = ContentScale.Crop,
                tag = items[page].getSupportTag(),
                distance = items[page].getSupportDes(),
            )
        }

        // Indicator dọc bên trái
        Column(
            modifier = Modifier
                .padding(
                    start = Dimens.pdMedium,
                    top = Dimens.pdBiger,
                )
                .fillMaxHeight(),
        ) {
            repeat(pageCount) { index ->
                val isSelected = pagerState.currentPage == index
                Box(
                    modifier = Modifier
                        .size(Dimens.sizeIndicator+Dimens.pdSmallest)
                        .padding(Dimens.pdSmallest)
                        .clip(CircleShape)
                        .background(if (isSelected) yellowOr else Color.White)
                )
            }
        }

    }
}
