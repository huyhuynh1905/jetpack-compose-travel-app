package com.example.travelapp.domain.usecase

import com.example.travelapp.domain.base.BaseUseCase
import com.example.travelapp.domain.repository.AccountRepository
import javax.inject.Inject

class AccountUseCase @Inject constructor(
    private val accountRepository: AccountRepository
) : BaseUseCase() {
    suspend fun getAccount() = accountRepository.getAccount()
}