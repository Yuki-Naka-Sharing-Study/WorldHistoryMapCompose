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
    selectedEra: String?
) {
    when (selectedEra) {

        "紀元前5世紀" -> {
            Marker(
                state = rememberMarkerState(position = LatLng(37.9695, 23.7162)), // サラミス
                title = "ペルシア戦争（サラミスの海戦）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )
        }

        "20世紀" -> {
            Marker(
                state = rememberMarkerState(position = LatLng(49.0328, 3.9589)), // マルヌ
                title = "第一次世界大戦（マルヌの戦い）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )

            Marker(
                state = rememberMarkerState(position = LatLng(49.3389, -0.5580)), // ノルマンディー
                title = "第二次世界大戦（ノルマンディー上陸作戦）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )
        }
    }
}
