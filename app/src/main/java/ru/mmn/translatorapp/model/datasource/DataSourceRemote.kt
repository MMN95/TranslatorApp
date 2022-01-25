package ru.mmn.translatorapp.model.datasource

import io.reactivex.Observable
import ru.mmn.translatorapp.model.data.DataModel

class DataSourceRemote(private val remoteProvider: RetrofitImplementation = RetrofitImplementation()) :
    DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)
}