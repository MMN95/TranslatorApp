package ru.mmn.translatorapp.view.history

import ru.mmn.historyscreen.mapSearchResultToResult
import ru.mmn.translatorapp.model.data.AppState
import ru.mmn.translatorapp.model.data.SearchResultDto
import ru.mmn.translatorapp.model.repository.Repository
import ru.mmn.translatorapp.model.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : ru.mmn.core.viewmodel.Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            mapSearchResultToResult(
                if (fromRemoteSource) {
                    repositoryRemote
                } else {
                    repositoryLocal
                }.getData(word)
            )
        )
    }
}