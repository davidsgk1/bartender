package com.keegandavidson.bartender.ui

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import com.keegandavidson.bartender.model.Drink

interface MainContract {

    interface View : MvpView {
        fun updateState(drink: Drink)
        fun onError()
    }

    interface Presenter : MvpPresenter<View> {
        fun onGetRandomClicked()
    }
}