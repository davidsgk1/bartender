package com.keegandavidson.bartender.data

import com.keegandavidson.bartender.model.DrinksList
import retrofit2.Response

interface SearchRepository {

    suspend fun getRandomDrink(): Response<DrinksList?>

    suspend fun searchDrinkByName(name: String): Response<DrinksList?>
}