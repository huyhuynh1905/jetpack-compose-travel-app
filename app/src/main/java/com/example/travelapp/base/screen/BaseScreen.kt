package com.example.travelapp.base.screen

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.travelapp.utils.resource.Dimens

@Composable
fun <VM: BaseViewModel>BaseScreen (
    viewModel: VM,
    isSafeArea: Boolean = true,
    content: @Composable (VM) -> Unit
){
    if(isSafeArea){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = Dimens.statusBarHeight,
                    bottom = Dimens.navSysBarHeight
                )
        ){
            content(viewModel)
        }
    } else {
        content(viewModel)
    }
}