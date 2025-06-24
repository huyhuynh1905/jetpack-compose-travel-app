package com.example.travelapp.presentation.mainfeature.homescreen

import androidx.compose.animation.core.copy
import androidx.lifecycle.viewModelScope
import com.example.travelapp.R
import com.example.travelapp.base.screen.BaseViewModel
import com.example.travelapp.domain.model.AccountModel
import com.example.travelapp.domain.model.PlaceModel
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

    private val _listPlace = MutableStateFlow<List<PlaceModel>>(mutableListOf())
    var placeModels = _listPlace.asStateFlow()

    init {
        getAccountInfo()
        getTagList()
        getListPlaceModels()
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


    fun getListPlaceModels(){
        _listPlace.value = listOf<PlaceModel>(
            PlaceModel(
                "https://images.baodantoc.vn/uploads/2021/Th%C3%A1ng%209/Ng%C3%A0y_18/Thanh/15-2386.jpg",
                "Lễ hội Cung Đình",
                "#place",
                "216km"
            ),
            PlaceModel(
                "https://cdn3.ivivu.com/2023/10/du-lich-hue-ivivu.jpg",
                "Cầu Tràng Tiền,\nSông Hương",
                "#place",
                "51km"
            ),
            PlaceModel(
                "https://disantrangan.vn/wp-content/uploads/2021/11/lang_tu_duc_hue-07-1.jpg",
                "Khiêm Lăng",
                "#place",
                "25km"
            ),
            PlaceModel(
                "https://chauphuochuy.com/files/assets/langkhaidinh.jpg",
                "Ứng Lăng",
                "#place",
                "112km"
            ),
            PlaceModel(
                "https://tapchidongnama.vn/wp-content/uploads/2024/05/z5407241112687_81d9581d6dcc34e3992df1c2a9a38a2c.jpg",
                "Chùa Thiên Mụ",
                "#place",
                "13km"
            ),
            PlaceModel(
                "https://bazantravel.com/cdn/medias/uploads/72/72587-nui-ngu-binh-hue.jpg",
                "Núi Ngự",
                "#place",
                "5km"
            ),
            PlaceModel(
                "https://hiddenlandtravel.com/vi/wp-content/uploads/2020/09/lang-minh-mang.png",
                "Hiếu Lăng",
                "#place",
                "111km"
            ),
            PlaceModel(
                "https://disantrangan.vn/wp-content/uploads/2021/11/lang_gia_long_hue_01.jpg",
                "Thiên Thọ Lăng",
                "#place",
                "87km"
            ),
            PlaceModel(
                "https://static.vinwonders.com/production/dan-nam-giao-2.jpg",
                "Đàn Nam Giao",
                "#place",
                "55km"
            ),
            PlaceModel(
                "https://bthcm.hue.gov.vn/Portals/0/Medias/Nam2022/T10/quochochue.jpg",
                "Quốc Học Huế",
                "#place",
                "23km"
            ),

        )
    }
}
