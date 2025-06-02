package com.example.travelapp.di

import android.content.SharedPreferences
import com.example.travelapp.data.repository.SettingAppRepoImpl
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
    fun settingAppRepository(
        sharedPreferences: SharedPreferences,
    ): SettingAppRepository {
        return SettingAppRepoImpl(sharedPreferences)
    }

}