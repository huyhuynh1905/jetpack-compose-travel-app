package com.example.travelapp.presentation.mainfeature.homescreen

import androidx.lifecycle.viewModelScope
import com.example.travelapp.base.screen.BaseViewModel
import com.example.travelapp.domain.model.AccountModel
import com.example.travelapp.domain.usecase.AccountUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val accountUseCase: AccountUseCase
) : BaseViewModel() {

    private val _accountModel = MutableStateFlow<AccountModel?>(null)
    var accountModel = _accountModel.asStateFlow()

    init {
        getAccountInfo()
    }

    fun getAccountInfo(){
        viewModelScope.launch {
            _accountModel.value = accountUseCase.getAccount(1)
        }
    }
}
