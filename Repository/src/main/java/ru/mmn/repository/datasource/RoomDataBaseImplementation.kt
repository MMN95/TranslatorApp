package ru.mmn.translatorapp.model.datasource

import ru.mmn.repository.convertDataModelSuccessToEntity
import ru.mmn.repository.mapHistoryEntityToSearchResult
import ru.mmn.translatorapp.model.data.AppState
import ru.mmn.translatorapp.model.data.DataModel
import ru.mmn.translatorapp.room.HistoryDao


class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}