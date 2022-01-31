package ru.mmn.translatorapp.model.repository

interface Repository<T> {

    suspend fun getData(word: String): T
}