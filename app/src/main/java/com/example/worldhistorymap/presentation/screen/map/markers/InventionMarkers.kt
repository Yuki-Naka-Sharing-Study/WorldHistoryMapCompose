package com.example.worldhistorymap.presentation.screen.map.markers

import android.content.Context
import androidx.compose.runtime.Composable
import com.example.worldhistorymap.R
import com.example.worldhistorymap.util.bitmapDescriptorFromDrawable
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun InventionMarkers(
    context: Context,
    visible: Boolean
) {
    if (!visible) return

    val kittyHawk = LatLng(36.0646, -75.7050)

    Marker(
        state = rememberMarkerState(position = kittyHawk),
        title = "飛行機の発明",
        icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
        visible = true,
        onClick = { false }
    )
}
