package com.example.travelapp.presentation.onboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.distinctUntilChanged
import androidx.navigation.NavController
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.presentation.onboard.page.OnBoardPageOne
import com.example.travelapp.presentation.onboard.page.OnBoardPageThree
import com.example.travelapp.presentation.onboard.page.OnBoardPageTwo
import kotlinx.coroutines.flow.distinctUntilChanged

@Composable
fun OnBoardPageMain(nav: NavController) {

    BaseScreen(viewModel = hiltViewModel<OnBoardPageMainViewModel>()) { viewModel ->
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {

            val pageCountFromViewModel = viewModel.pageCount
            val selectedPageIndexByViewModel by viewModel.selectedPageIndex.collectAsState()
            // val currentVisiblePageByViewModel by viewModel.currentVisiblePage.collectAsState() // Nếu cần

            // 1. PagerState được tạo và nhớ trong Composable
            val pagerState = rememberPagerState(
                initialPage = selectedPageIndexByViewModel, // Trang khởi tạo từ ViewModel
                pageCount = { pageCountFromViewModel }
            )

            // 2. Đồng bộ Pager khi selectedPageIndexByViewModel từ ViewModel thay đổi
            // (ví dụ: người dùng click vào một nút "Next" điều khiển bởi ViewModel)
            LaunchedEffect(selectedPageIndexByViewModel) {
                if (pagerState.currentPage != selectedPageIndexByViewModel) {
                    pagerState.animateScrollToPage(selectedPageIndexByViewModel)
                }
            }

            // 3. Đồng bộ ViewModel khi Pager được người dùng vuốt hoặc cuộn xong
            LaunchedEffect(pagerState) {
                snapshotFlow { pagerState.currentPage } // Quan sát sự thay đổi của trang hiện tại
                    .distinctUntilChanged() // Chỉ phát ra khi giá trị thực sự thay đổi
                    .collect { page ->
                        viewModel.onPageSelectedChange(page)
                    }
            }


            HorizontalPager(
                state = pagerState
            ) { page ->
                when (page) {
                    0 -> OnBoardPageOne(viewModel)
                    1 -> OnBoardPageTwo(viewModel)
                    2 -> OnBoardPageThree(viewModel)
                }
            }

        }
    }

}