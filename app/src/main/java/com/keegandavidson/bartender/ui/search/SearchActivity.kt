package com.keegandavidson.bartender.ui.search

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import com.hannesdorfmann.mosby3.mvp.MvpActivity
import com.keegandavidson.bartender.databinding.ActivitySearchBinding
import com.keegandavidson.bartender.model.SearchResult
import com.keegandavidson.bartender.util.di.injectDependencies
import javax.inject.Inject

class SearchActivity : MvpActivity<SearchContract.View, SearchContract.Presenter>(), SearchContract.View {

    @Inject internal lateinit var searchPresenter: SearchContract.Presenter

    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    override fun createPresenter() = searchPresenter

    override fun updateState(results: List<SearchResult>) {
        TODO("Not yet implemented")
    }

    override fun onError() {
        TODO("Not yet implemented")
    }

    private fun initViews() = with(binding) {
        searchInput.setEndIconOnClickListener { presenter.searchDrinkByName(searchInput.editText?.text.toString()) }
        searchInput.editText?.setOnEditorActionListener { _, actionId, _ ->
             when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    presenter.searchDrinkByName(searchInput.editText?.text.toString())
                    true
                }
                 else -> false
            }
        }
    }
}