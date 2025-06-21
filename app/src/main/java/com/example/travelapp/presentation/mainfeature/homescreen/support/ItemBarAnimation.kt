package com.example.travelapp.presentation.mainfeature.homescreen.support

data class ItemBarAnimation(
    var title: String,
    var icon: Int,
    var itemClick: Int
) {
    companion object {
        const val HOME = 0
        const val PLANT = 1
        const val BAG = 2
        const val FRIEND = 3
        const val DIARY = 4
        const val SEARCH = 5
    }
}
