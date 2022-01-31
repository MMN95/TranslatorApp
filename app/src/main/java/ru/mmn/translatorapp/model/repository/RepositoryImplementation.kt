package ru.mmn.translatorapp.model.repository

import ru.mmn.translatorapp.model.data.DataModel
import ru.mmn.translatorapp.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}