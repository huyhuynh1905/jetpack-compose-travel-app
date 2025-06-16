package com.example.travelapp.presentation.loginfeature.loginsuccess

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.travelapp.base.screen.BaseViewModel
import com.example.travelapp.domain.model.AccountModel
import com.example.travelapp.domain.usecase.AccountUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginSuccessViewModel @Inject constructor(
    private val accountUseCase: AccountUseCase
) : BaseViewModel() {


    fun saveAccount(onSuccess: () -> Unit) {
        viewModelScope.launch {
            accountUseCase.saveAccount(AccountModel(
                id = 1,
                name = "John Doe",
                email = "john@gmail.com",
                phone = "0986868686",
                avatarUrl = "https://upload.wikimedia.org/wikipedia/commons/1/1a/Faker_2020_interview.jpg"
            ))
            onSuccess()
        }
    }
}