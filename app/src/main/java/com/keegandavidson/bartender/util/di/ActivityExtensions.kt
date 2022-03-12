package com.keegandavidson.bartender.util.di

import com.keegandavidson.bartender.BartenderApplication
import com.keegandavidson.bartender.ui.MainActivity

fun MainActivity.injectDependencies() {
    (applicationContext as BartenderApplication).appComponent.inject(this)
}