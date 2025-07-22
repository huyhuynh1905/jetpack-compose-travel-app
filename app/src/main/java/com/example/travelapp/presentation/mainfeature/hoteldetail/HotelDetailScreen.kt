package com.example.travelapp.presentation.mainfeature.hoteldetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.presentation.mainfeature.hoteldetail.pages.PageTabBarView
import com.example.travelapp.ui.component.AppBarComponent
import com.example.travelapp.ui.navigation.Arguments
import com.example.travelapp.ui.navigation.LocalNavController

@Composable
fun HotelDetailScreen(){
    BaseScreen(
        viewModel = hiltViewModel<HotelDetailViewModel>(),
        isSafeArea = false
    ) { vm ->
        val navController = LocalNavController.current

        val title = navController?.currentBackStackEntry?.arguments?.getString(Arguments.TITLE_HOTEL)

        Column(
            modifier = Modifier
                .background(Color.White)
        ) {
            AppBarComponent(
                title = title?:"",
                navController = navController!!,
            )

            PageTabBarView()


        }
    }
}