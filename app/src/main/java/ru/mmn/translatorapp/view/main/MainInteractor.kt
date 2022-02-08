package ru.mmn.translatorapp.view.main

import ru.mmn.translatorapp.model.data.AppState
import ru.mmn.translatorapp.model.data.SearchResultDto
import ru.mmn.translatorapp.model.repository.Repository
import ru.mmn.translatorapp.model.repository.RepositoryLocal
import ru.mmn.translatorapp.utils.mapSearchResultToResult


class MainInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : ru.mmn.core.viewmodel.Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(mapSearchResultToResult(repositoryRemote.getData(word)))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(mapSearchResultToResult(repositoryLocal.getData(word)))
        }
        return appState
    }
}