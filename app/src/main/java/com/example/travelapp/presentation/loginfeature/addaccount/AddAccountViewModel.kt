package com.example.travelapp.presentation.loginfeature.addaccount

import androidx.compose.ui.graphics.Color
import com.example.travelapp.R
import com.example.travelapp.base.screen.BaseViewModel
import com.example.travelapp.presentation.loginfeature.addaccount.support.TypeAddAccountEntity
import com.example.travelapp.ui.themes.blueFb
import com.example.travelapp.ui.themes.redBg
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AddAccountViewModel @Inject constructor() : BaseViewModel() {
    private val listType = MutableStateFlow<List<TypeAddAccountEntity>>(mutableListOf())
    val listTypeState = listType.asStateFlow()

    private val selectTypeAdd = MutableStateFlow<TypeAddAccountEntity?>(null)
    val selectTypeAddState = selectTypeAdd.asStateFlow()

    init {
        initListDataTypeAdd()
    }

    private fun initListDataTypeAdd() {
        val listSample = mutableListOf<TypeAddAccountEntity>()
        listSample.add(TypeAddAccountEntity(R.drawable.ic_google_white, getStringResource(R.string.add_google), redBg))
        listSample.add(TypeAddAccountEntity(R.drawable.ic_facebook_white, getStringResource(R.string.add_facebook), blueFb))
        listSample.add(TypeAddAccountEntity(R.drawable.ic_user_red, getStringResource(R.string.add_user), Color.White))

        listType.value = listSample
        if(listType.value.isNotEmpty()){
            selectTypeAdd.value = listType.value.first()
        }
    }

    fun onChangeSelectedTypeAcc(newValue: TypeAddAccountEntity){
        if(!newValue.equals(selectTypeAdd.value)){
            selectTypeAdd.value = newValue
        }
    }
}