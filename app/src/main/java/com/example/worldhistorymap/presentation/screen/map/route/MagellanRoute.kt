package com.example.worldhistorymap.presentation.screen.map.route

import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberMarkerState
import kotlinx.coroutines.delay

@Composable
fun MagellanRoute(
    selectedEra: String?,
    cameraPositionState: CameraPositionState
) {
    if (selectedEra == "16世紀") {
        val routePoints = listOf(
            LatLng(36.5333, -6.2833),   // スペイン・セビリア（出発）
            LatLng(-34.6037, -58.3816), // 南アメリカ・リオ・デ・ラ・プラタ（補給）
            LatLng(-52.6200, -70.9400), // マゼラン海峡（通過）
            LatLng(-17.7134, -149.4068), // 太平洋・タヒチ周辺
            LatLng(13.4443, 144.7937),  // グアム（補給）
            LatLng(10.3157, 123.8854),  // フィリピン・セブ島（マゼラン戦死）
            LatLng(-34.9205, -57.9536), // 喜望峰を回って帰還（カナリア諸島経由）
            LatLng(36.5333, -6.2833)    // スペイン・セビリア（帰還）
        )

        LaunchedEffect("magellan") {
            for (point in routePoints) {
                cameraPositionState.animate(
                    update = CameraUpdateFactory.newLatLngZoom(point, 3.5f),
                    durationMs = 1000
                )
                delay(3000) // 各地点で一時停止
            }
        }

        // 主なマーカー
        Marker(
            state = rememberMarkerState(position = routePoints[0]),
            title = "マゼランの経路：セビリア（出発）"
        )
        Marker(
            state = rememberMarkerState(position = routePoints[5]),
            title = "マゼランの経路：セブ島（マゼラン戦死）"
        )
        Marker(
            state = rememberMarkerState(position = routePoints[7]),
            title = "マゼランの経路：セビリア（帰還）"
        )

        // 航路線
        Polyline(
            points = routePoints,
            color = Color.Blue,
            width = 6f
        )
    }
}
