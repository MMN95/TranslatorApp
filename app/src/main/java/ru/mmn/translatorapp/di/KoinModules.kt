package ru.mmn.translatorapp.di

import androidx.room.Room
import org.koin.dsl.module
import ru.mmn.translatorapp.database.HistoryDataBase
import ru.mmn.translatorapp.model.data.DataModel
import ru.mmn.translatorapp.model.datasource.RetrofitImplementation
import ru.mmn.translatorapp.model.datasource.RoomDataBaseImplementation
import ru.mmn.translatorapp.model.repository.Repository
import ru.mmn.translatorapp.model.repository.RepositoryImplementation
import ru.mmn.translatorapp.view.history.HistoryInteractor
import ru.mmn.translatorapp.view.main.MainInteractor
import ru.mmn.translatorapp.viewmodel.HistoryViewModel
import ru.mmn.translatorapp.viewmodel.MainViewModel


val application = module {

    single { Room.databaseBuilder(get(), HistoryDataBase::class.java,
    "HistoryDB").build() }

    single { get<HistoryDataBase>().historyDao() }

    single<Repository<List<DataModel>>> {
        RepositoryImplementation(
            RetrofitImplementation()
        )
    }
    single<Repository<List<DataModel>>> {
        RepositoryImplementation(
            RoomDataBaseImplementation()
        )
    }
}
val mainScreen = module {
    factory { MainInteractor(get(), get()) }
    factory { MainViewModel(get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}

