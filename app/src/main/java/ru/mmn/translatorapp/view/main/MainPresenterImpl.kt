package ru.mmn.translatorapp.view.main

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import ru.mmn.translatorapp.model.data.AppState
import ru.mmn.translatorapp.model.datasource.DataSourceLocal
import ru.mmn.translatorapp.model.datasource.DataSourceRemote
import ru.mmn.translatorapp.model.repository.RepositoryImplementation
import ru.mmn.translatorapp.presenter.Presenter
import ru.mmn.translatorapp.rx.SchedulerProvider
import ru.mmn.translatorapp.view.base.View

class MainPresenterImpl<T : AppState, V : View>(

    private val interactor: MainInteractor = MainInteractor(
        RepositoryImplementation(DataSourceRemote()),
        RepositoryImplementation(DataSourceLocal())
    ),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : Presenter<T, V> {
    private var currentView: V? = null

    override fun attachView(view: V) {
        if (view != currentView) {
            currentView = view
        }
    }

    override fun detachView(view: V) {
        compositeDisposable.clear()
        if (view == currentView) {
            currentView = null
        }
    }

    override fun getData(word: String, isOnline: Boolean) {
        compositeDisposable.add(
            interactor.getData(word, isOnline)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .doOnSubscribe { currentView?.renderData(AppState.Loading(null)) }
                .subscribeWith(getObserver())
        )
    }

    private fun getObserver(): DisposableObserver<AppState> {
        return object : DisposableObserver<AppState>() {

            override fun onNext(appState: AppState) {
                currentView?.renderData(appState)
            }

            override fun onError(e: Throwable) {
                currentView?.renderData(AppState.Error(e))
            }

            override fun onComplete() {
            }
        }
    }
}