package com.example.worldhistorymap.util

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import androidx.core.content.ContextCompat
import com.example.worldhistorymap.data.Battle
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader


fun bitmapDescriptorFromDrawable(context: Context, drawableResId: Int): BitmapDescriptor? {
    val drawable = ContextCompat.getDrawable(context, drawableResId)
    return if (drawable is BitmapDrawable) {
        BitmapDescriptorFactory.fromBitmap(drawable.bitmap)
    } else {
        null
    }
}

fun loadBattlesFromAssets(context: Context): List<Battle> {
    val assetManager = context.assets
    val inputStream = assetManager.open("battles.json")
    val reader = InputStreamReader(inputStream)

    val battleListType = object : TypeToken<List<Battle>>() {}.type
    return Gson().fromJson(reader, battleListType)
}
