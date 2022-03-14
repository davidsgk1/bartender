package com.keegandavidson.bartender.ui.search

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.keegandavidson.bartender.model.SearchResult

interface SearchContract {

    interface View : MvpView {
        fun updateState(results: List<SearchResult>)
        fun onError()
    }

    interface Presenter : MvpPresenter<View> {
        fun searchDrinkByName(name: String)
    }
}