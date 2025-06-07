package com.example.travelapp.presentation.loginfeature.selectaccount

import com.example.travelapp.base.screen.BaseViewModel
import com.example.travelapp.domain.model.SelectAccountModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SelectAccountViewModel @Inject constructor() : BaseViewModel() {

    private val listAccount = MutableStateFlow<List<SelectAccountModel>>(mutableListOf())
    val listAccountState = listAccount.asStateFlow()

    private val selectedAccount = MutableStateFlow<SelectAccountModel?>(null)
    val selectedAccountState = selectedAccount.asStateFlow()

    init {
        fetchUser()
    }

    ///Nếu nhiều hơn 3 user thì slip chỉ lấy 3 user gần nhất login
    fun fetchUser(){
        val listSample = mutableListOf<SelectAccountModel>()
        listSample.add(SelectAccountModel(1,"Mash Smith", "smith@gmail.com","","https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2020/12/30/866476/Lisa-Blackpink-3.jpg"))
        listSample.add(SelectAccountModel(2,"Wilma West", "wilma@gmail.com","","https://phunuso.mediacdn.vn/603486343963435008/2025/5/29/taylor-swift-the-eras-tour-london-uk-1748478212499-17484782128681879652871.jpg"))
        listSample.add(SelectAccountModel(3,"Bennett Botsford", "bennett@gmail.com","","https://parade.com/.image/ar_4:3%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTkwNTc4NzQ2NjU0ODYxMTgw/tom-holland-spider-man-ftr.jpg"))

        listAccount.value = listSample
        if(listAccount.value.isNotEmpty()){
            selectedAccount.value = listAccount.value.first()
        }
    }

    fun onChangeSelectedAcc(newValue: SelectAccountModel){
        if(!newValue.equals(selectedAccount.value)){
            selectedAccount.value = newValue
        }
    }


}