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
        val columbusTitles = listOf(
            "コロンブスの経路：パロス（出発地）",
            "コロンブスの経路：カナリア諸島（中継地）",
            "コロンブスの経路：サンサルバドル島（到達地）"
        )

        val magellanPoints = listOf(
            LatLng(36.5333, -6.2833),   // セビリア
            LatLng(-34.6037, -58.3816), // リオ・デ・ラ・プラタ
            LatLng(-52.6200, -70.9400), // マゼラン海峡
            LatLng(-17.7134, -149.4068), // 太平洋・タヒチ
            LatLng(13.4443, 144.7937),  // グアム
            LatLng(10.3157, 123.8854),  // セブ島
            LatLng(-34.9205, -57.9536), // 喜望峰
            LatLng(36.5333, -6.2833)    // セビリア帰還
        )
        val magellanTitles = listOf(
            "マゼランの経路：セビリア（出発地）",
            "マゼランの経路：リオ・デ・ラ・プラタ（補給地）",
            "マゼランの経路：マゼラン海峡（通過）",
            "マゼランの経路：太平洋（タヒチ付近）",
            "マゼランの経路：グアム（補給地）",
            "マゼランの経路：セブ島（マゼラン戦死）",
            "マゼランの経路：喜望峰（帰還航路）",
            "マゼランの経路：セビリア（帰還）"
        )

        // アニメーション
        LaunchedEffect(selectedEra) {
            for (point in columbusPoints) {
                cameraPositionState.animate(
                    update = CameraUpdateFactory.newLatLngZoom(point, 4f),
                    durationMs = 1000
                )
                delay(3000)
            }
            for (point in magellanPoints) {
                cameraPositionState.animate(
                    update = CameraUpdateFactory.newLatLngZoom(point, 3.5f),
                    durationMs = 1000
                )
                delay(3000)
            }
        }

        columbusPoints.forEachIndexed { index, point ->
            Marker(
                state = rememberMarkerState(position = point),
                title = columbusTitles[index]
            )
        }

        magellanPoints.forEachIndexed { index, point ->
            Marker(
                state = rememberMarkerState(position = point),
                title = magellanTitles[index]
            )
        }

        Polyline(
            points = columbusPoints,
            color = Color.Blue,
            width = 6f
        )
        Polyline(
            points = magellanPoints,
            color = Color.Blue,
            width = 6f
        )
    }
}
