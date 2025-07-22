package com.example.travelapp.presentation.mainfeature.hoteldetail.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.travelapp.ui.themes.gray
import com.example.travelapp.ui.themes.yellowOr
import com.example.travelapp.utils.extension.customClickable
import com.example.travelapp.utils.resource.Dimens
import kotlinx.coroutines.launch

const val pageHotelCount = 4

@Composable
fun PageTabBarView(){
    val pagerState = rememberPagerState(pageCount = {pageHotelCount}, initialPage = 0)
    val scope = rememberCoroutineScope()

    val tabs = listOf("Detail", "Rooms", "Convenient", "Reviews")

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = Dimens.pdMedium
                )
        ) {
            tabs.forEach { item ->
                Box(
                    modifier = Modifier
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    ItemTabBar(
                        item = item,
                        isSelected = pagerState.currentPage == tabs.indexOf(item),
                        onClick = {
                            scope.launch { pagerState.animateScrollToPage(tabs.indexOf(item)) }
                        }
                    )
                }
            }
        }
        HorizontalPager(
            pageSize = PageSize.Fill,
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
        ) { page ->
            when (page) {
                0 -> HotelDetail()
                1 -> HotelRooms()
                2 -> HotelConvenient()
                3 -> HotelReviews()
            }
        }


    }
}


@Composable
fun ItemTabBar(item: String, isSelected: Boolean, onClick: () -> Unit){
    if(isSelected){
        Card(
            modifier = Modifier
                .wrapContentWidth()
                .customClickable(
                    rippleColor = yellowOr,
                    onClick = {
                        onClick()
                    }
                ), // Khoảng cách xung quanh Card
            shape = RoundedCornerShape(Dimens.circleRadius),
            elevation = CardDefaults.cardElevation(defaultElevation = Dimens.elevationNormal),
            colors = CardDefaults.cardColors(containerColor = yellowOr)
        ) {
            Box(
                modifier = Modifier
                    .padding(Dimens.pdSmall)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = item,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.White,
                        fontSize = Dimens.textSizeNormal
                    )
                )
            }
        }
    } else {
        Box(
            modifier = Modifier
                .padding(Dimens.pdSmall)
                .fillMaxWidth()
                .customClickable(
                    rippleColor = yellowOr,
                    onClick = {
                        onClick()
                    }
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = item,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = gray,
                    fontSize = Dimens.textSizeNormal
                )
            )
        }
    }
}