package com.keegandavidson.bartender.util.ui

import android.content.Context
import android.content.Intent
import com.keegandavidson.bartender.ui.MainActivity
import com.keegandavidson.bartender.ui.search.SearchActivity

/**
 * Heads up: when you want to add a new activity to the application and send it via a deeplink, you will need to
 * Add a new value to the DeepLinkTag enum class and then adjust InternalDeepLink#computeTarget to send
 * the intent to the correct class.
 */
object InternalDeepLink {

    fun sendToActivity(context: Context, tag: DeepLinkTag = DeepLinkTag.MAIN) {
        val target = computeTarget(tag)
        val intent = Intent(context, target)
        context.startActivity(intent)
    }

    private fun computeTarget(tag: DeepLinkTag) = when(tag) {
        DeepLinkTag.SEARCH -> SearchActivity::class.java
        else -> MainActivity::class.java
    }
}