package ru.mmn.translatorapp.view.main

import ru.mmn.translatorapp.model.data.AppState
import ru.mmn.translatorapp.model.data.DataModel
import ru.mmn.translatorapp.model.repository.Repository
import ru.mmn.translatorapp.model.repository.RepositoryLocal
import ru.mmn.core.viewmodel.Interactor


class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : ru.mmn.core.viewmodel.Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}