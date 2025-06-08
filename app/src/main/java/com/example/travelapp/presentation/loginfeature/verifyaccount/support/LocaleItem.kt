package com.example.travelapp.presentation.loginfeature.verifyaccount.support

data class LocaleItem(
    private var logo: Int,
    private var title: String
) : SupportItemDropdown{
    override fun getTitle(): String {
        return  title
    }

    override fun getLogo(): Int {
        return logo
    }

}