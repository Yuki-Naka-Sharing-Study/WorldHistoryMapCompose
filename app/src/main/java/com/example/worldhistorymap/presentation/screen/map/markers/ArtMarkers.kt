package com.example.worldhistorymap.presentation.screen.map.markers

import android.content.Context
import androidx.compose.runtime.Composable
import com.example.worldhistorymap.R
import com.example.worldhistorymap.util.bitmapDescriptorFromDrawable
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun ArtMarkers(
    context: Context,
    selectedEra: String?
) {
    if (selectedEra == "17世紀") {
        val versailles = LatLng(48.8049, 2.1204)

        Marker(
            state = rememberMarkerState(position = versailles),
            title = "ヴェルサイユ宮殿",
            icon = bitmapDescriptorFromDrawable(context, R.drawable.art_icon),
            visible = true,
            onClick = { false }
        )
    }
}
