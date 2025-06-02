package com.example.travelapp.presentation.splash

import com.example.travelapp.base.screen.BaseViewModel
import com.example.travelapp.domain.usecase.SettingAppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val settingAppUseCase: SettingAppUseCase
) : BaseViewModel() {

    init {
        showLog("SplashViewModel init call")
    }

    fun isFirstOpen(): Boolean {
        showLog("isFirstOpen call: ${settingAppUseCase.isFirstOpen()}")
        return settingAppUseCase.isFirstOpen()
    }

}