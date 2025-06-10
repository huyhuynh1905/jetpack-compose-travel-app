package com.example.travelapp.presentation.loginfeature.createaccount

import androidx.lifecycle.viewModelScope
import com.example.travelapp.base.screen.BaseViewModel
import com.example.travelapp.presentation.loginfeature.createaccount.support.DialogDisplayState
import com.example.travelapp.presentation.loginfeature.createaccount.support.DialogScreenEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CreateAccountViewModel @Inject constructor() : BaseViewModel() {

    private val _dialogState = MutableStateFlow<DialogDisplayState>(DialogDisplayState.Hidden)
    val dialogState = _dialogState.asStateFlow() // Expose as StateFlow (read-only)

    fun onEvent(event: DialogScreenEvent) {
        viewModelScope.launch { // Sử dụng viewModelScope cho coroutines
            when (event) {
                is DialogScreenEvent.ShowDialogButtonClicked -> {
                    _dialogState.value = DialogDisplayState.Showing(
                        title = event.title,
                        message = event.message
                    )
                }
                is DialogScreenEvent.ConfirmDialog -> {
                    // Xử lý logic khi người dùng xác nhận
                    println("Dialog Confirmed by user!")
                    _dialogState.value = DialogDisplayState.Hidden // Ẩn dialog
                }
                is DialogScreenEvent.DismissDialog -> {
                    // Xử lý logic khi người dùng hủy bỏ (hoặc dialog bị dismiss)
                    println("Dialog Dismissed by user!")
                    _dialogState.value = DialogDisplayState.Hidden // Ẩn dialog
                }
            }
        }
    }

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