package com.keegandavidson.bartender.data

import com.keegandavidson.bartender.model.DrinksList
import retrofit2.Response
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val searchClient: SearchClient) : SearchRepository {

    override suspend fun getRandomDrink(): Response<DrinksList?> {
        return searchClient.getRandomDrink()
    }

    override suspend fun searchDrinkByName(name: String): Response<DrinksList?> {
        return searchClient.searchDrinkByName(name)
    }
}