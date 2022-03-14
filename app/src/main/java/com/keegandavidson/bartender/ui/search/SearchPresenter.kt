package com.keegandavidson.bartender.ui.search

import com.keegandavidson.bartender.data.SearchRepository
import com.keegandavidson.bartender.model.DrinksList
import com.keegandavidson.bartender.ui.search.domain.SearchResultMapper
import com.keegandavidson.bartender.util.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchPresenter @Inject constructor(
    private val searchRepository: SearchRepository,
    private val searchResultMapper: SearchResultMapper
) : BasePresenter<SearchContract.View>(), SearchContract.Presenter {

    override fun searchDrinkByName(name: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = searchRepository.searchDrinkByName(name)
            if (result.isSuccessful) {
                val data = result.body() ?: DrinksList()
                ifViewAttached { it.updateState(searchResultMapper(data)) }
            } else {
                ifViewAttached { it.onError() }
            }
        }
    }
}