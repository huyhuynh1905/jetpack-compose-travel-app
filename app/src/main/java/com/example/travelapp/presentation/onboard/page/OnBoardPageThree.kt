package com.example.travelapp.presentation.onboard.page

import androidx.compose.runtime.Composable
import com.example.travelapp.R
import com.example.travelapp.presentation.onboard.OnBoardPageMainViewModel
import com.example.travelapp.ui.navigation.LocalNavController
import com.example.travelapp.ui.navigation.ScreenNames

@Composable
fun OnBoardPageThree(viewModel: OnBoardPageMainViewModel) {
    val navController = LocalNavController.current

    PageOnBoardView(
        currentPage = 0,
        idBgk = R.drawable.img_onboard3,
        goBack = {
            viewModel.onPageSelectedChange(1)
        },
        goNext = {
            viewModel.saveFirstOpen()
            navController?.navigate(ScreenNames.SELECT_ACC_SCREEN) {
                // Xóa all back stack
                popUpTo(0) {
                    inclusive = true // Quan trọng: Bao gồm cả ONBOARD_SCREEN trong việc xóa
                }
                launchSingleTop = true
            }
        }
    )
}
