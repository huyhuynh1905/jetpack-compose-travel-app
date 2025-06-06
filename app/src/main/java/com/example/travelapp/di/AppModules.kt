package com.example.travelapp.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // Cung cấp instance này ở cấp Application
object AppModules {

    @Provides
    @Singleton
    fun providerSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return  context.getSharedPreferences("travel_app_shareds", Context.MODE_PRIVATE)
    }

}