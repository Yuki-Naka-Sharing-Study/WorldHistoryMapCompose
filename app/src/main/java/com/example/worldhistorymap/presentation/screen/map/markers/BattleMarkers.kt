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
    // 15世紀：百年戦争（ジャンヌ・ダルクの活躍）
    if (selectedEra == "15世紀") {
        Marker(
            state = rememberMarkerState(position = LatLng(48.8566, 2.3522)),
            title = "百年戦争（ジャンヌ・ダルクの活躍）",
            icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
            visible = true,
            onClick = { false }
        )
    }

    // 17世紀：三十年戦争
    if (selectedEra == "17世紀") {
        Marker(
            state = rememberMarkerState(position = LatLng(52.5200, 13.4050)),
            title = "三十年戦争",
            icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
            visible = true,
            onClick = { false }
        )
    }

    // 18世紀：アメリカ独立戦争（ヨークタウンの戦い）
    if (selectedEra == "18世紀") {
        Marker(
            state = rememberMarkerState(position = LatLng(37.2383, -76.5097)),
            title = "アメリカ独立戦争（ヨークタウンの戦い）",
            icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
            visible = true,
            onClick = { false }
        )
    }

    // 19世紀：ナポレオン戦争（ワーテルローの戦い）
    if (selectedEra == "19世紀") {
        Marker(
            state = rememberMarkerState(position = LatLng(50.6806, 4.4128)),
            title = "ナポレオン戦争（ワーテルローの戦い）",
            icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
            visible = true,
            onClick = { false }
        )
    }

    // 20世紀：第一次世界大戦（ソンムの戦い）
    if (selectedEra == "20世紀") {
        Marker(
            state = rememberMarkerState(position = LatLng(50.0200, 2.6500)),
            title = "第一次世界大戦（ソンムの戦い）",
            icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
            visible = true,
            onClick = { false }
        )
    }

    // 20世紀：第二次世界大戦（ノルマンディー上陸作戦）
    if (selectedEra == "20世紀") {
        Marker(
            state = rememberMarkerState(position = LatLng(49.4144, -0.8486)),
            title = "第二次世界大戦（ノルマンディー上陸作戦）",
            icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
            visible = true,
            onClick = { false }
        )
    }
}
