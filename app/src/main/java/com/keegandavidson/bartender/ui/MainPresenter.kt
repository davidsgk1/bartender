package com.keegandavidson.bartender.ui

import com.keegandavidson.bartender.data.SearchRepository
import com.keegandavidson.bartender.model.Drink
import com.keegandavidson.bartender.model.DrinksList
import com.keegandavidson.bartender.util.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainPresenter @Inject constructor(private val searchRepository: SearchRepository) : BasePresenter<MainContract.View>(), MainContract.Presenter {

    override fun onGetRandomClicked() {
        CoroutineScope(Dispatchers.IO).launch {
            val result = searchRepository.getRandomDrink()
            withContext(Dispatchers.Main) {
                if (result.isSuccessful) {
                    val data = result.body() ?: DrinksList()
                    ifViewAttached { it.updateState(data.drinks?.first() ?: Drink()) }
                } else {
                    ifViewAttached { it.onError() }
                }
            }
        }
    }
}