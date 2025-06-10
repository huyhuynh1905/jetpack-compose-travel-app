package com.example.travelapp.presentation.loginfeature.createaccount.support

// Event mà UI sẽ gửi lên ViewModel
sealed class DialogScreenEvent {
    data class ShowDialogButtonClicked(val title: String, val message: String) : DialogScreenEvent()
    object ConfirmDialog : DialogScreenEvent()
    object DismissDialog : DialogScreenEvent()
}

// State để quản lý việc hiển thị dialog
sealed class DialogDisplayState {
    object Hidden : DialogDisplayState() // Dialog đang ẩn
    data class Showing(val title: String, val message: String) : DialogDisplayState() // Dialog đang hiển thị với thông tin
}