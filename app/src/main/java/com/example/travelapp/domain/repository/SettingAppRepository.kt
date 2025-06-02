package com.example.travelapp.domain.repository

interface SettingAppRepository : BaseRepository {
    fun isFirstOpenApp() : Boolean
    fun saveFirstOpenApp(isFirstOpen: Boolean = false)
}