package com.example.travelapp.presentation.loginfeature.verifyaccount

import com.example.travelapp.R
import com.example.travelapp.base.screen.BaseViewModel
import com.example.travelapp.presentation.loginfeature.verifyaccount.support.LocaleItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class VerifyAccountViewModel @Inject constructor() : BaseViewModel() {

    private val listLocaleType: MutableStateFlow<List<LocaleItem>> = MutableStateFlow<List<LocaleItem>>(mutableListOf())
    val listState = listLocaleType.asStateFlow()

    private val selectLocaleType: MutableStateFlow<LocaleItem?> = MutableStateFlow<LocaleItem?>(null)
    val selectState = selectLocaleType.asStateFlow()

    init {
        initLocaleList()
    }

    fun initLocaleList(){
        val listSample = mutableListOf<LocaleItem>()
        listSample.add(LocaleItem(R.drawable.ic_flag_vietnam, "+84"))
        listSample.add(LocaleItem(R.drawable.ic_flag_america, "+1"))
        listSample.add(LocaleItem(R.drawable.ic_flag_china, "+61"))
        listSample.add(LocaleItem(R.drawable.ic_flag_eng, "+10"))
        listLocaleType.value = listSample
        if(listLocaleType.value.isNotEmpty()){
            selectLocaleType.value = listLocaleType.value.first()
        }
    }

    fun updateLocaleType(item: LocaleItem){
        selectLocaleType.value = item
    }
}