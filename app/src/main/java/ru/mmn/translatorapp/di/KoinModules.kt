package ru.mmn.translatorapp.di

import androidx.room.Room
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.mmn.translatorapp.model.data.SearchResultDto
import ru.mmn.translatorapp.model.datasource.RetrofitImplementation
import ru.mmn.translatorapp.model.datasource.RoomDataBaseImplementation
import ru.mmn.translatorapp.model.repository.Repository
import ru.mmn.translatorapp.model.repository.RepositoryImplementation
import ru.mmn.translatorapp.model.repository.RepositoryImplementationLocal
import ru.mmn.translatorapp.model.repository.RepositoryLocal
import ru.mmn.translatorapp.room.HistoryDataBase
import ru.mmn.translatorapp.view.history.HistoryActivity
import ru.mmn.translatorapp.view.history.HistoryInteractor
import ru.mmn.translatorapp.view.history.HistoryViewModel
import ru.mmn.translatorapp.view.main.MainActivity
import ru.mmn.translatorapp.view.main.MainInteractor
import ru.mmn.translatorapp.view.main.MainViewModel


val application = module {

    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }

    single { get<HistoryDataBase>().historyDao() }

    single<Repository<List<SearchResultDto>>> { RepositoryImplementation(RetrofitImplementation()) }

    single<RepositoryLocal<List<SearchResultDto>>> { RepositoryImplementationLocal(RoomDataBaseImplementation(get())) }
}

val mainScreen = module {
    scope(named<MainActivity>()) {
        scoped { MainInteractor(get(), get()) }
        viewModel { MainViewModel(get()) }
    }
}

val historyScreen = module {
    scope(named<HistoryActivity>()) {
        scoped { HistoryInteractor(get(), get()) }
        viewModel { HistoryViewModel(get()) }
    }
}

