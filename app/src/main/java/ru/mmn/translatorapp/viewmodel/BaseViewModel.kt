package ru.mmn.translatorapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ru.mmn.translatorapp.model.data.AppState
import ru.mmn.translatorapp.rx.SchedulerProvider

abstract class BaseViewModel<T : AppState>(
    protected val liveDataForViewToObserve: MutableLiveData<T> = MutableLiveData(),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : ViewModel() {

    open fun getData(word: String, isOnline: Boolean): LiveData<T> = liveDataForViewToObserve

    override fun onCleared() {
        compositeDisposable.clear()
    }
}

