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
    selectedEra: String? // ← 世紀を受け取る
) {
    // ヨークタウン（18世紀, 1783年）
    if (selectedEra == "18世紀") {
        Marker(
            state = rememberMarkerState(position = LatLng(37.2383, -76.5097)),
            title = "ヨークタウンの独立",
            icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
            visible = true,
            onClick = { false }
        )
    }

    // トラファルガー（19世紀, 1805年）
    if (selectedEra == "19世紀") {
        Marker(
            state = rememberMarkerState(position = LatLng(36.8333, -6.1333)),
            title = "トラファルガーの海戦",
            icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
            visible = true,
            onClick = { false }
        )
    }
}

