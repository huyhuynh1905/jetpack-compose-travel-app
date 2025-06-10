package com.example.travelapp.base.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.travelapp.utils.resource.Dimens

@Composable
fun <VM: BaseViewModel>BaseScreen (
    viewModel: VM,
    isSafeArea: Boolean = true,
    background: Color? = null,
    content: @Composable (VM) -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .then(
                if (background != null) {
                    Modifier.background(color = background)
                } else {
                    Modifier
                }
            )
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
}