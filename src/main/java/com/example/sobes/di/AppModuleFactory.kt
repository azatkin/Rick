package com.example.sobes.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.sobes.presentation.MainScreenViewModel
import javax.inject.Inject
import javax.inject.Provider

class AppModuleFactory @Inject constructor(
    mainScreenViewModel: Provider<MainScreenViewModel>,
) : ViewModelProvider.Factory {

    private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
        MainScreenViewModel::class.java to mainScreenViewModel,
    )

    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return providers[modelClass]?.get() as T
    }
}