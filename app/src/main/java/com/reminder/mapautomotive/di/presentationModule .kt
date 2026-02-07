package com.reminder.mapautomotive.di

import com.reminder.mapautomotive.ui.auth.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel {
        LoginViewModel(
            get()
        )
    }


}