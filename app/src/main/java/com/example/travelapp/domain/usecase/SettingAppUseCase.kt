package com.example.travelapp.domain.usecase

import com.example.travelapp.domain.repository.SettingAppRepository
import javax.inject.Inject

class SettingAppUseCase @Inject constructor(
    private val settingAppRepository: SettingAppRepository
) : BaseUseCase() {

    fun isFirstOpen(): Boolean = settingAppRepository.isFirstOpenApp()

    fun saveFirstOpen(isFirstOpen: Boolean = false) = settingAppRepository.saveFirstOpenApp(isFirstOpen)
}