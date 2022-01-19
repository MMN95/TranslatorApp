package ru.mmn.translatorapp.view.base

import androidx.appcompat.app.AppCompatActivity
import ru.mmn.translatorapp.model.data.AppState
import ru.mmn.translatorapp.viewmodel.BaseViewModel

abstract class BaseActivity<T : AppState> : AppCompatActivity() {

    abstract val model: BaseViewModel<T>

    abstract fun renderData(appState: T)
}