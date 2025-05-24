package com.example.worldhistorymap.presentation.screen.map.markers

import android.content.Context
import androidx.compose.runtime.Composable
import com.example.worldhistorymap.R
import com.example.worldhistorymap.util.bitmapDescriptorFromDrawable
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun BattleMarkers(
    context: Context,
    visible: Boolean
) {
    if (!visible) return

    val yorktown = LatLng(37.2383, -76.5097)
    val trafalgar = LatLng(36.8333, -6.1333)

    Marker(
        state = rememberMarkerState(position = yorktown),
        title = "ヨークタウンの独立",
        icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
        visible = true,
        onClick = { false }
    )
    Marker(
        state = rememberMarkerState(position = trafalgar),
        title = "トラファルガーの海戦",
        icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
        visible = true,
        onClick = { false }
    )
}
