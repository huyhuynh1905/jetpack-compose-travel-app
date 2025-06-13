package com.example.travelapp.domain.repository

import com.example.travelapp.domain.base.BaseRepository

interface SettingAppRepository : BaseRepository {
    fun isFirstOpenApp() : Boolean
    fun saveFirstOpenApp(isFirstOpen: Boolean = false)
}