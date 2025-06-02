package com.example.travelapp.presentation.onboard

import androidx.compose.foundation.pager.rememberPagerState
import com.example.travelapp.base.screen.BaseViewModel
import com.example.travelapp.domain.usecase.SettingAppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class OnBoardPageMainViewModel @Inject constructor(
    private val settingsUseCase : SettingAppUseCase
) : BaseViewModel() {

    // Số lượng trang
    val pageCount = 3

    // ViewModel sẽ giữ index của trang hiện tại/được chọn.
    // Composable sẽ quan sát giá trị này để có thể cuộn Pager đến đó.
    private val _selectedPageIndex = MutableStateFlow(0)
    val selectedPageIndex: StateFlow<Int> = _selectedPageIndex.asStateFlow()



    fun saveFirstOpen() {
        settingsUseCase.saveFirstOpen(isFirstOpen = false)
    }

    /**
     * Được gọi từ Composable khi người dùng click vào một chỉ báo/tab để chọn trang.
     */
    fun onPageSelectedChange(index: Int) {
        if (index in 0 until pageCount) {
            _selectedPageIndex.value = index
        }
    }


}