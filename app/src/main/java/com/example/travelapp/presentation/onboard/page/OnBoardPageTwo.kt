package com.example.travelapp.presentation.onboard.page

import androidx.compose.runtime.Composable
import com.example.travelapp.R
import com.example.travelapp.presentation.onboard.OnBoardPageMainViewModel
import com.example.travelapp.ui.navigation.LocalNavController

@Composable
fun OnBoardPageTwo(viewModel: OnBoardPageMainViewModel) {
    PageOnBoardView(
        currentPage = 0,
        idBgk = R.drawable.img_onboard2,
        goBack = {
            viewModel.onPageSelectedChange(0)
        },
        goNext = {
            viewModel.onPageSelectedChange(2)
        }
    )
}