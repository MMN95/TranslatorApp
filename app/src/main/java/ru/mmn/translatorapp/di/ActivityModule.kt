package ru.mmn.translatorapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.mmn.translatorapp.view.main.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}