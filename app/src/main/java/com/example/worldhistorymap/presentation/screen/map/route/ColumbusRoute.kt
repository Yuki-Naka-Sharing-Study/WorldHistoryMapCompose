package com.example.worldhistorymap.presentation.screen.map.route

import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.Polyline
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import kotlinx.coroutines.delay

@Composable
fun ColumbusRoute(
    selectedEra: String?
) {
    if (selectedEra == "15世紀" || selectedEra == "16世紀") {
        val cameraPositionState = rememberCameraPositionState()

        val routePoints = listOf(
            LatLng(37.2159, -7.0145),   // パロス
            LatLng(28.2936, -16.6214),  // カナリア諸島
            LatLng(24.0634, -74.5240)   // サンサルバドル島
        )

        LaunchedEffect(Unit) {
            for (point in routePoints) {
                cameraPositionState.animate(
                    update = CameraUpdateFactory.newLatLngZoom(point, 4f),
                    durationMs = 1000
                )
                delay(10000) // 各地点で一時停止
            }
        }

        // マーカー（出発・中継・到達）
        Marker(
            state = rememberMarkerState(position = routePoints[0]),
            title = "コロンブスの経路：パロス（出発地）"
        )
        Marker(
            state = rememberMarkerState(position = routePoints[1]),
            title = "コロンブスの経路：カナリア諸島（中継地）"
        )
        Marker(
            state = rememberMarkerState(position = routePoints[2]),
            title = "コロンブスの経路：サンサルバドル島（到達地）"
        )

        // 航路線
        Polyline(
            points = routePoints,
            color = Color.Blue,
            width = 6f
        )
    }
}
