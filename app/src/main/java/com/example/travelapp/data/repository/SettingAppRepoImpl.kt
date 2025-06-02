package com.example.travelapp.data.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.travelapp.domain.repository.SettingAppRepository
import javax.inject.Inject

class SettingAppRepoImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) : SettingAppRepository {

    override fun isFirstOpenApp(): Boolean {
        return sharedPreferences.getBoolean("is_first_open", true)
    }

    override fun saveFirstOpenApp(isFirstOpen: Boolean) {
        sharedPreferences.edit(commit = false) { putBoolean("is_first_open", isFirstOpen) }
    }

}


