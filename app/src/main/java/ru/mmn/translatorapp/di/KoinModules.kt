package ru.mmn.translatorapp.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.mmn.translatorapp.model.data.DataModel
import ru.mmn.translatorapp.model.datasource.RetrofitImplementation
import ru.mmn.translatorapp.model.datasource.RoomDataBaseImplementation
import ru.mmn.translatorapp.model.repository.Repository
import ru.mmn.translatorapp.model.repository.RepositoryImplementation
import ru.mmn.translatorapp.view.main.MainInteractor
import ru.mmn.translatorapp.view.main.MainViewModel


val application = module {

    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) {
        RepositoryImplementation(
            RetrofitImplementation()
        )
    }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) {
        RepositoryImplementation(
            RoomDataBaseImplementation()
        )
    }
}
val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}

