package com.keegandavidson.bartender.di

import com.keegandavidson.bartender.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [
    NetworkModule::class
])
@Singleton
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
}