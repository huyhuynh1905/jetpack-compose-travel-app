package com.example.travelapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.travelapp.data.base.BaseEntity

@Entity(tableName = "account")
data class AccountEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String = "",
    var phone: String = "",
    var email: String = "",
    var avatarUrl: String = ""

)