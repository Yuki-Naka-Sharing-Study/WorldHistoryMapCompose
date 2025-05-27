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
fun RouteAnimationController(
    selectedEra: String?,
    cameraPositionState: CameraPositionState
) {
    if (selectedEra == "16世紀") {
        val columbusPoints = listOf(
            LatLng(37.2159, -7.0145),   // パロス
            LatLng(28.2936, -16.6214),  // カナリア諸島
            LatLng(24.0634, -74.5240)   // サンサルバドル島
        )

        val magellanPoints = listOf(
            LatLng(36.5333, -6.2833),   // セビリア
            LatLng(-34.6037, -58.3816),
            LatLng(-52.6200, -70.9400),
            LatLng(-17.7134, -149.4068),
            LatLng(13.4443, 144.7937),
            LatLng(10.3157, 123.8854),
            LatLng(-34.9205, -57.9536),
            LatLng(36.5333, -6.2833)
        )

        LaunchedEffect(selectedEra) {
            // 🎯 Columbusのルートアニメーション
            for (point in columbusPoints) {
                cameraPositionState.animate(
                    update = CameraUpdateFactory.newLatLngZoom(point, 4f),
                    durationMs = 1000
                )
                delay(3000)
            }

            // 🎯 Magellanのルートアニメーション
            for (point in magellanPoints) {
                cameraPositionState.animate(
                    update = CameraUpdateFactory.newLatLngZoom(point, 3.5f),
                    durationMs = 1000
                )
                delay(3000)
            }
        }

        // Columbusの描画（常時表示）
        columbusPoints.forEachIndexed { index, point ->
            Marker(
                state = rememberMarkerState(position = point),
                title = "Columbus Point ${index + 1}"
            )
        }
        Polyline(
            points = columbusPoints,
            color = Color.Blue,
            width = 6f
        )

        // Magellanの描画（常時表示）
        magellanPoints.forEachIndexed { index, point ->
            Marker(
                state = rememberMarkerState(position = point),
                title = "Magellan Point ${index + 1}"
            )
        }
        Polyline(
            points = magellanPoints,
            color = Color.Blue,
            width = 6f
        )
    }
}
