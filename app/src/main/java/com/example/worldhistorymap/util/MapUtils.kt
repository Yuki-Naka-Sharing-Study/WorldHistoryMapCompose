package com.example.worldhistorymap.util

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory

fun bitmapDescriptorFromDrawable(context: Context, drawableResId: Int): BitmapDescriptor? {
    val drawable = ContextCompat.getDrawable(context, drawableResId)
    return if (drawable is BitmapDrawable) {
        BitmapDescriptorFactory.fromBitmap(drawable.bitmap)
    } else {
        null
    }
}
