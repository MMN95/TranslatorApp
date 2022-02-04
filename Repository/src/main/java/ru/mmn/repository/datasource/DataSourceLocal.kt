package ru.mmn.translatorapp.model.datasource

import ru.mmn.translatorapp.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}