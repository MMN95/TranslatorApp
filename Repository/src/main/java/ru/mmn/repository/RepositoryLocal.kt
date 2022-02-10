package ru.mmn.translatorapp.model.repository

import ru.mmn.translatorapp.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}