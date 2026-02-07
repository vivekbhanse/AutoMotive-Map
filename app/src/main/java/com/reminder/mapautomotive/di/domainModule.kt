package com.reminder.mapautomotive.di

import com.reminder.mapautomotive.domain.usecase.LoginUseCase
import org.koin.dsl.module

val domainModule = module {
    // UseCases
    factory { LoginUseCase(get()) }

}