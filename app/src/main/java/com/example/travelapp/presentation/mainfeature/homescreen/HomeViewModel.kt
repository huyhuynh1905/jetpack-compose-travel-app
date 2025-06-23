package com.example.travelapp.presentation.mainfeature.homescreen

import androidx.compose.animation.core.copy
import androidx.lifecycle.viewModelScope
import com.example.travelapp.R
import com.example.travelapp.base.screen.BaseViewModel
import com.example.travelapp.domain.model.AccountModel
import com.example.travelapp.domain.usecase.AccountUseCase
import com.example.travelapp.presentation.mainfeature.homescreen.support.ItemTagFilter
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

    private val _tagList = MutableStateFlow<List<ItemTagFilter>>(mutableListOf())
    var tagList = _tagList.asStateFlow()

    init {
        getAccountInfo()
        getTagList()
    }

    fun getAccountInfo(){
        viewModelScope.launch {
            _accountModel.value = accountUseCase.getAccount(1)
        }
    }

    fun getTagList(){
        _tagList.value = listOf<ItemTagFilter>(
            ItemTagFilter("Place", true, R.drawable.ic_location),
            ItemTagFilter("Hotel", false, R.drawable.ic_hotel),
            ItemTagFilter("Restaurant", false, R.drawable.ic_restaurant),
            ItemTagFilter("Relax", false, R.drawable.ic_hot_relax),
        )
    }

    fun selectedItemTagfFilter(item: ItemTagFilter){
        val newItems = _tagList.value.map {
            // Nếu là item đang được duyệt và ID khớp với item được click
            if (it.name == item.name) {
                it.copy(isSelected = true) // Đặt isSelected của item được click thành true
            }
            // Nếu là item đang được duyệt nhưng isSelected đang là true (và không phải item vừa click)
            else if (it.isSelected) {
                it.copy(isSelected = false) // Đặt isSelected của item cũ thành false
            }
            // Các item khác giữ nguyên
            else {
                it
            }
        }
        _tagList.value = newItems
    }
}
