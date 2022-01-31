package ru.mmn.translatorapp.model.datasource

import ru.mmn.translatorapp.model.data.DataModel

class RoomDataBaseImplementation : DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        TODO("not implemented")
    }
}