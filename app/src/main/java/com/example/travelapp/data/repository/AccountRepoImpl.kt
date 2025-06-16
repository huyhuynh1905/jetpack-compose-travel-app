package com.example.travelapp.data.repository

import com.example.travelapp.data.local.database.dao.AccountDao
import com.example.travelapp.data.mapper.AccountMapper
import com.example.travelapp.domain.model.AccountModel
import com.example.travelapp.domain.repository.AccountRepository
import javax.inject.Inject

class AccountRepoImpl @Inject constructor(
    private val accountDao: AccountDao,
    private val accountMapper: AccountMapper
) : AccountRepository {

    override suspend fun getAccount(id: Long): AccountModel? {
        val acc = accountDao.getAccountById(id)
        return accountMapper.toModel(acc)
    }

    override suspend fun insertAccount(account: AccountModel): Long {
        val acc = accountMapper.toEntity(account)
        return accountDao.insertAccount(acc)
    }
}