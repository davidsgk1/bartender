package com.keegandavidson.bartender.ui

import android.os.Bundle
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.keegandavidson.bartender.BartenderApplication
import com.keegandavidson.bartender.databinding.ActivityMainBinding
import com.keegandavidson.bartender.model.Drink
import javax.inject.Inject

class MainActivity : MvpActivity<MainContract.View, MainContract.Presenter>(), MainContract.View {

    @Inject lateinit var mainPresenter: MainContract.Presenter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        (applicationContext as BartenderApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    override fun updateState(drink: Drink) = with(binding) {
        drinkLabel.text = drink.strDrink
    }

    override fun onError() = with(binding) {
        drinkLabel.text = "You fucked up!"
    }

    override fun createPresenter() = mainPresenter

    private fun initViews() = with(binding) {
        drinkButton.setOnClickListener { presenter.onGetRandomClicked() }
    }
}