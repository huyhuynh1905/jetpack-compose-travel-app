package com.example.travelapp.presentation.mainfeature.hoteldetail

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travelapp.base.screen.BaseScreen

@Composable
fun HotelDetailScreen(){
    BaseScreen(viewModel = hiltViewModel<HotelDetailViewModel>()) { vm ->

    }
}