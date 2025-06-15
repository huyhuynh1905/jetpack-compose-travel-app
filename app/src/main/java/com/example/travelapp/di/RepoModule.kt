package com.example.travelapp.di

import android.content.SharedPreferences
import com.example.travelapp.data.local.database.dao.AccountDao
import com.example.travelapp.data.mapper.AccountMapper
import com.example.travelapp.data.repository.AccountRepoImpl
import com.example.travelapp.data.repository.SettingAppRepoImpl
import com.example.travelapp.domain.repository.AccountRepository
import com.example.travelapp.domain.repository.SettingAppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // Cung cấp instance này ở cấp Application
object RepoModule {

    @Provides
    @Singleton
    fun settingAppRepository25(
        sharedPreferences: SharedPreferences,
    ): SettingAppRepository {
        return SettingAppRepoImpl(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideAccountRepository(accountDao: AccountDao, accountMapper: AccountMapper): AccountRepository {
        return AccountRepoImpl(accountDao, accountMapper)
    }


}