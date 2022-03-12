package com.keegandavidson.bartender.data

import com.keegandavidson.bartender.model.DrinksList
import retrofit2.Response
import retrofit2.http.GET

interface SearchApi {

    @GET("random.php")
    suspend fun getRandomDrink(): Response<DrinksList?>
}