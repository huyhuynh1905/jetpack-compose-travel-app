package com.example.travelapp.di

import com.example.travelapp.data.mapper.AccountMapper
import dagger.Provides
import javax.inject.Singleton

object MapperModules {
    @Provides
    @Singleton
    fun provideAccountMapper(): AccountMapper {
        return AccountMapper()
    }
}