package com.keegandavidson.bartender.util.di

import com.keegandavidson.bartender.BartenderApplication
import com.keegandavidson.bartender.ui.MainActivity
import com.keegandavidson.bartender.ui.search.SearchActivity

fun MainActivity.injectDependencies() {
    (applicationContext as BartenderApplication).appComponent.inject(this)
}

fun SearchActivity.injectDependencies() {
    (applicationContext as BartenderApplication).appComponent.inject(this)
}