package ru.mmn.translatorapp.di

import dagger.Module
import dagger.Provides
import ru.mmn.translatorapp.model.data.DataModel
import ru.mmn.translatorapp.model.repository.Repository
import ru.mmn.translatorapp.view.main.MainInteractor
import javax.inject.Named

@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: Repository<List<DataModel>>,
        @Named(NAME_LOCAL) repositoryLocal: Repository<List<DataModel>>
    ) = MainInteractor(repositoryRemote, repositoryLocal)
}