package com.keegandavidson.bartender.di

import com.keegandavidson.bartender.ui.MainActivity
import com.keegandavidson.bartender.ui.search.SearchActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [MainModule::class])
@Singleton
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(searchActivity: SearchActivity)
}