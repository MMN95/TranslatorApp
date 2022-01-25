package ru.mmn.translatorapp.view.base

import ru.mmn.translatorapp.model.data.AppState

interface View {

    fun renderData(appState: AppState)
}