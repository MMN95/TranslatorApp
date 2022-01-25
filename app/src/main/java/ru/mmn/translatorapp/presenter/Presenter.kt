package ru.mmn.translatorapp.presenter

import ru.mmn.translatorapp.model.data.AppState
import ru.mmn.translatorapp.view.base.View

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)
}