package com.example.travelapp.di

import com.example.travelapp.data.mapper.AccountMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModules {
    @Provides
    @Singleton
    fun provideAccountMapper(): AccountMapper {
        return AccountMapper()
    }
}