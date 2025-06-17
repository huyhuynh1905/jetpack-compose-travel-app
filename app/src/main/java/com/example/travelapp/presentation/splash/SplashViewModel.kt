package com.example.travelapp.presentation.splash

import androidx.lifecycle.viewModelScope
import com.example.travelapp.base.screen.BaseViewModel
import com.example.travelapp.domain.model.AccountModel
import com.example.travelapp.domain.usecase.AccountUseCase
import com.example.travelapp.domain.usecase.SettingAppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val settingAppUseCase: SettingAppUseCase,
    private val accountUseCase: AccountUseCase
) : BaseViewModel() {

    var acc : AccountModel? = null

    init {
        getAccount()
    }

    fun isFirstOpen(): Boolean {
        showLog("isFirstOpen call: ${settingAppUseCase.isFirstOpen()}")
        return settingAppUseCase.isFirstOpen()
    }

    fun getAccount(){
        viewModelScope.launch {
            acc = accountUseCase.getAccount(1)
            showLog("SplashViewModel init getAccount done")
        }

    }
}