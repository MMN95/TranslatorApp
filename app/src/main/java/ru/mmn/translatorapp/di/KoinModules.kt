package ru.mmn.translatorapp.di

import androidx.room.Room
import org.koin.dsl.module
import ru.mmn.translatorapp.model.data.DataModel
import ru.mmn.translatorapp.model.datasource.RetrofitImplementation
import ru.mmn.translatorapp.model.datasource.RoomDataBaseImplementation
import ru.mmn.translatorapp.model.repository.Repository
import ru.mmn.translatorapp.model.repository.RepositoryImplementation
import ru.mmn.translatorapp.model.repository.RepositoryImplementationLocal
import ru.mmn.translatorapp.model.repository.RepositoryLocal
import ru.mmn.translatorapp.room.HistoryDataBase
import ru.mmn.translatorapp.view.history.HistoryInteractor
import ru.mmn.translatorapp.view.history.HistoryViewModel
import ru.mmn.translatorapp.view.main.MainInteractor
import ru.mmn.translatorapp.view.main.MainViewModel


val application = module {

    single {
        Room.databaseBuilder(
            get(), HistoryDataBase::class.java,
            "HistoryDB"
        ).build()
    }

    single { get<HistoryDataBase>().historyDao() }

    single<Repository<List<DataModel>>> {
        RepositoryImplementation(
            RetrofitImplementation()
        )
    }
    single<RepositoryLocal<List<DataModel>>> {
        RepositoryImplementationLocal(
            RoomDataBaseImplementation(get())
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

