package com.example.travelapp.presentation.loginfeature.createaccount

import com.example.travelapp.base.screen.BaseViewModel
import javax.inject.Inject

class CreateAccountViewModel @Inject constructor() : BaseViewModel() {

    fun createAccountAction(
        fullname: String,
        emailAdrress: String,
        password: String,
        onSucces: () -> Unit = {},
        onError: (String) -> Unit = {}
    ) {
        onSucces()
    }
}