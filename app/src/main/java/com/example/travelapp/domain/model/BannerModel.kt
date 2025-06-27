package com.example.travelapp.domain.model

import com.example.travelapp.ui.component.carousel.SupportModel

data class BannerModel(
    val id: Int,
    val imageUrl: String,
    val title: String,
    val tag: String,
    val description: String,
) : SupportModel {
    override fun getSupportTitle(): String {
        return title
    }

    override fun getSupportImage(): String {
        return imageUrl
    }

    override fun getSupportTag(): String {
        return tag
    }

    override fun getSupportDes(): String {
        return description
    }

}
