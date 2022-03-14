package com.keegandavidson.bartender.ui.search.domain

import com.keegandavidson.bartender.model.DrinksList
import com.keegandavidson.bartender.model.SearchResult
import javax.inject.Inject

class SearchResultMapper @Inject constructor() : Function1<DrinksList, List<SearchResult>> {

    override fun invoke(drinksList: DrinksList): List<SearchResult> {
        return drinksList.drinks.orEmpty().map {
            SearchResult(
                id = it?.idDrink.orEmpty(),
                drinkName = it?.strDrink.orEmpty(),
                isAlcoholic = it?.strAlcoholic.orEmpty(),
                thumbnailUrl = it?.strDrinkThumb.orEmpty()
            )
        }
    }
}