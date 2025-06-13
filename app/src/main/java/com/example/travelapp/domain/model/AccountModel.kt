package com.example.travelapp.domain.model

import com.example.travelapp.domain.base.BaseModel

data class AccountModel(
    val id: Long,
    val name: String,
    val email: String,
    val phone: String,
    val avatarUrl: String
) : BaseModel(){

}