package ru.mmn.translatorapp.model.data.api

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query
import ru.mmn.translatorapp.model.data.SearchResultDto

interface ApiService {

    @GET("words/search")
    fun searchAsync(@Query("search") wordToSearch: String): Deferred<List<SearchResultDto>>
}