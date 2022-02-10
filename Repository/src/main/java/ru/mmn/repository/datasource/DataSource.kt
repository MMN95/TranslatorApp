package ru.mmn.translatorapp.model.datasource

interface DataSource<T> {

    suspend fun getData(word: String): T
}