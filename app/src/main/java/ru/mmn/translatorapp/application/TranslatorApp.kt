package ru.mmn.translatorapp.application

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.mmn.translatorapp.di.application
import ru.mmn.translatorapp.di.historyScreen
import ru.mmn.translatorapp.di.mainScreen

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}

