package com.keegandavidson.bartender

import android.app.Application
import com.keegandavidson.bartender.di.DaggerApplicationComponent

class BartenderApplication : Application() {

    val appComponent = DaggerApplicationComponent.create()
}