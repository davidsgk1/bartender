package com.keegandavidson.bartender.data

import com.keegandavidson.bartender.model.DrinksList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("random.php")
    suspend fun getRandomDrink(): Response<DrinksList?>

    @GET("search.php")
    suspend fun searchDrinkByName(@Query("s") name: String): Response<DrinksList?>
}