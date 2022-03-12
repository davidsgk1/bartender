package com.keegandavidson.bartender.data

import com.keegandavidson.bartender.model.DrinksList
import retrofit2.Response
import javax.inject.Inject

class SearchClient @Inject constructor(private val searchApi: SearchApi) {
    suspend fun getRandomDrink(): Response<DrinksList?> {
        return searchApi.getRandomDrink()
    }
}