package com.example.travelapp.domain.repository

import com.example.travelapp.domain.base.BaseRepository
import com.example.travelapp.domain.model.AccountModel

interface AccountRepository : BaseRepository {
    suspend fun getAccount(id: Long): AccountModel?

    suspend fun insertAccount(account: AccountModel): Long
}