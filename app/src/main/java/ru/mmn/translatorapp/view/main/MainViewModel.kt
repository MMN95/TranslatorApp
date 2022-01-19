package ru.mmn.translatorapp.view.main

import androidx.lifecycle.LiveData
import io.reactivex.observers.DisposableObserver
import ru.mmn.translatorapp.model.data.AppState
import ru.mmn.translatorapp.model.datasource.DataSourceLocal
import ru.mmn.translatorapp.model.datasource.DataSourceRemote
import ru.mmn.translatorapp.model.repository.RepositoryImplementation
import ru.mmn.translatorapp.viewmodel.BaseViewModel

class MainViewModel(
    private val interactor: MainInteractor = MainInteractor(
        RepositoryImplementation(DataSourceRemote()),
        RepositoryImplementation(DataSourceLocal())
    )
) : BaseViewModel<AppState>() {
    private var appState: AppState? = null
    override fun getData(word: String, isOnline: Boolean): LiveData<AppState> {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe { liveDataForViewToObserve.value = AppState.Loading(null) }

                .subscribeWith(getObserver())
        )
        return super.getData(word, isOnline)
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {
            override fun onNext(state: AppState) {
                appState = state
                liveDataForViewToObserve.value = state
            }

            override fun onError(e: Throwable) {
                liveDataForViewToObserve.value = AppState.Error(e)
            }

            override fun onComplete() {
            }
        }
    }
}

