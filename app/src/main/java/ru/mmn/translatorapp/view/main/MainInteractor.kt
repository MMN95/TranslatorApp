package ru.mmn.translatorapp.view.main

import io.reactivex.Observable
import ru.mmn.translatorapp.di.NAME_LOCAL
import ru.mmn.translatorapp.di.NAME_REMOTE
import ru.mmn.translatorapp.model.data.AppState
import ru.mmn.translatorapp.model.data.DataModel
import ru.mmn.translatorapp.model.repository.Repository
import ru.mmn.translatorapp.viewmodel.Interactor
import javax.inject.Inject
import javax.inject.Named


class MainInteractor @Inject constructor(
    @Named(NAME_REMOTE) val repositoryRemote: Repository<List<DataModel>>,
    @Named(NAME_LOCAL) val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            repositoryRemote
        } else {
            repositoryLocal
        }.getData(word).map { AppState.Success(it) }
    }
}