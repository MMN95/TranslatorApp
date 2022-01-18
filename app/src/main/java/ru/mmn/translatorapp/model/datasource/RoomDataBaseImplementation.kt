package ru.mmn.translatorapp.model.datasource

import io.reactivex.Observable
import ru.mmn.translatorapp.model.data.DataModel

class RoomDataBaseImplementation : DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("not implemented")
    }
}