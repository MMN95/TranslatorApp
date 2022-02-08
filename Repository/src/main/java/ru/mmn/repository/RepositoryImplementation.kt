package ru.mmn.translatorapp.model.repository

import ru.mmn.translatorapp.model.data.SearchResultDto
import ru.mmn.translatorapp.model.datasource.DataSource


class RepositoryImplementation(private val dataSource: DataSource<List<SearchResultDto>>) :
    Repository<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return dataSource.getData(word)
    }
}