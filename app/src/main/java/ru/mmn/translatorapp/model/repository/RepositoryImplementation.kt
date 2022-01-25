package ru.mmn.translatorapp.model.repository

import io.reactivex.Observable
import ru.mmn.translatorapp.model.data.DataModel
import ru.mmn.translatorapp.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}