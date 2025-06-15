package com.example.travelapp.presentation.mainfeature.homescreen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.travelapp.base.screen.BaseScreen
import com.example.travelapp.ui.component.Pixel6APreview

@Composable
fun HomeScreen(){
    BaseScreen(viewModel = hiltViewModel<HomeViewModel>()) { viewModel->

    }
}



@Pixel6APreview
@Composable
fun HomeScreePreView(){
    HomeScreen()
}