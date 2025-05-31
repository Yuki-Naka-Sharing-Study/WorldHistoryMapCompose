package com.example.worldhistorymap.presentation.screen.map.markers

import android.content.Context
import androidx.compose.runtime.Composable
import com.example.worldhistorymap.R
import com.example.worldhistorymap.util.bitmapDescriptorFromDrawable
import com.example.worldhistorymap.util.loadBattlesFromAssets
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun BattleMarkers(
    context: Context,
    selectedEra: String?
) {
    val battles = loadBattlesFromAssets(context)
    val filteredBattles = battles.filter { it.era == selectedEra }

    filteredBattles.forEach { battle ->
        Marker(
            state = rememberMarkerState(position = LatLng(battle.location.lat, battle.location.lng)),
            title = battle.name,
            icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
            visible = true,
            onClick = { false }
        )
    }
}
