package ru.mmn.translatorapp

import io.reactivex.Observable

interface DataSource<T> {

    fun getData(word: String): Observable<T>
}