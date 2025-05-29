package com.example.travelapp.base.screen

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

/**
 * Lớp ViewModel cơ sở trừu tượng theo kiến trúc MVI (Model-View-Intent) đơn giản hóa.
 */
abstract class BaseViewModel : ViewModel() {
    private val TAG = this::class.java.simpleName


    fun showLog(message: String){
        Log.d(TAG, message)
    }
}