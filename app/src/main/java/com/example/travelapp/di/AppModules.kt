package com.example.travelapp.di

import android.content.Context
import android.content.SharedPreferences
import com.example.travelapp.data.local.database.RoomDB
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

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): RoomDB {
        return RoomDB.getDatabase(context)
    }

    @Provides
    fun provideAccountDao(appDatabase: RoomDB) = appDatabase.accountDao()

}