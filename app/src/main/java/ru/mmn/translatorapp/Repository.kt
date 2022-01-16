package ru.mmn.translatorapp

import io.reactivex.Observable

interface Repository<T> {

    fun getData(word: String): Observable<T>
}