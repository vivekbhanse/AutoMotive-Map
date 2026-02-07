package com.reminder.mapautomotive

import android.app.Application
import androidx.core.os.BuildCompat
import com.reminder.mapautomotive.di.dataModule
import com.reminder.mapautomotive.di.domainModule
import com.reminder.mapautomotive.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import timber.log.Timber

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(
                domainModule,
                dataModule,
                presentationModule
            )

        }
    }
}