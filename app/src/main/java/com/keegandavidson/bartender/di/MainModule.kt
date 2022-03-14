package com.keegandavidson.bartender.di

import com.keegandavidson.bartender.data.SearchApi
import com.keegandavidson.bartender.data.SearchClient
import com.keegandavidson.bartender.data.SearchRepository
import com.keegandavidson.bartender.data.SearchRepositoryImpl
import com.keegandavidson.bartender.ui.MainContract
import com.keegandavidson.bartender.ui.MainPresenter
import com.keegandavidson.bartender.ui.search.SearchContract
import com.keegandavidson.bartender.ui.search.SearchPresenter
import com.keegandavidson.bartender.ui.search.domain.SearchResultMapper
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import javax.inject.Singleton

@Module
class MainModule {

    @Provides
    @Singleton
    fun provideSearchRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideSearchApi(retrofit: Retrofit): SearchApi {
        return retrofit.create(SearchApi::class.java)
    }

    @Provides
    fun provideSearchClient(searchApi: SearchApi): SearchClient {
        return SearchClient(searchApi)
    }

    @Provides
    fun provideSearchRepository(searchClient: SearchClient): SearchRepository {
        return SearchRepositoryImpl(searchClient)
    }

    @Provides
    fun provideSearchResultsMapper(): SearchResultMapper {
        return SearchResultMapper()
    }

    @Provides
    fun provideMainContractPresenter(searchRepository: SearchRepository): MainContract.Presenter {
        return MainPresenter(searchRepository)
    }

    @Provides
    fun provideSearchContractPresenter(searchRepository: SearchRepository, searchResultsMapper: SearchResultMapper): SearchContract.Presenter {
        return SearchPresenter(searchRepository, searchResultsMapper)
    }
}