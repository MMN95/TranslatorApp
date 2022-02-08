package ru.mmn.translatorapp.model.repository

import ru.mmn.translatorapp.model.data.AppState
import ru.mmn.translatorapp.model.data.SearchResultDto
import ru.mmn.translatorapp.model.datasource.DataSourceLocal


class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<SearchResultDto>>) :
    RepositoryLocal<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}