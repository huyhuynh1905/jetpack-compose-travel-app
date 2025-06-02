package com.example.travelapp.presentation.onboard.page

import androidx.compose.runtime.Composable
import com.example.travelapp.R
import com.example.travelapp.presentation.onboard.OnBoardPageMainViewModel
import com.example.travelapp.ui.navigation.LocalNavController

@Composable
fun OnBoardPageOne(viewModel: OnBoardPageMainViewModel) {
    val navController = LocalNavController.current
    PageOnBoardView(
        currentPage = 0,
        idBgk = R.drawable.img_onboard1,
        goBack = {
            navController?.popBackStack()
        },
        goNext = {
            viewModel.onPageSelectedChange(1)
        }
    )
}