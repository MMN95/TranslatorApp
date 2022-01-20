package ru.mmn.translatorapp.view.base

import androidx.appcompat.app.AppCompatActivity
import ru.mmn.translatorapp.model.data.AppState
import ru.mmn.translatorapp.viewmodel.BaseViewModel
import ru.mmn.translatorapp.viewmodel.Interactor

abstract class BaseActivity<T : AppState, I: Interactor<T>> : AppCompatActivity() {

    abstract val model: BaseViewModel<T>

    abstract fun renderData(appState: T)
}