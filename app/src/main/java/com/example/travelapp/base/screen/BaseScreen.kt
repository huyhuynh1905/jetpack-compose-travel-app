package com.example.travelapp.base.screen

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.LocalLifecycleOwner

@Composable
fun <VM: BaseViewModel>BaseScreen (
    viewModel: VM,
    content: @Composable (VM) -> Unit
){
    content(viewModel)
}