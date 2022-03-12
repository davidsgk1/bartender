package com.keegandavidson.bartender.util.ui

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

//TODO: Add error/fallback image to application
fun View.loadRemoteImage(remoteUrl: String, targetImageView: ImageView) {
    Glide.with(this)
        .load(remoteUrl)
        .into(targetImageView)
}