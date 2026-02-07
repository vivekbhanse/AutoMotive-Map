package com.reminder.mapautomotive.di

import com.reminder.mapautomotive.data.repository.AuthRepositoryImpl
import com.reminder.mapautomotive.domain.repository.AuthRepository
import org.koin.dsl.module

val dataModule = module{
    single<AuthRepository> { AuthRepositoryImpl() }
}