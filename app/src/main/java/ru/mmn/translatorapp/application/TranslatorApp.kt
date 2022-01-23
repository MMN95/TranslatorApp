package ru.mmn.translatorapp.application

import android.app.Application
import org.koin.core.context.startKoin
import ru.mmn.translatorapp.di.application
import ru.mmn.translatorapp.di.mainScreen

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}

