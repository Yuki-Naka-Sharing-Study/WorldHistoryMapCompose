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
    LaunchedEffect(selectedEra) {
        if (selectedEra == "15世紀" || selectedEra == "16世紀") {
            for (point in columbusPoints) {
                cameraPositionState.animate(
                    update = CameraUpdateFactory.newLatLngZoom(point, 4f),
                    durationMs = 1000
                )
                delay(3000)
            }
        }
        if (selectedEra == "16世紀") {
            for (point in magellanPoints) {
                cameraPositionState.animate(
                    update = CameraUpdateFactory.newLatLngZoom(point, 3.5f),
                    durationMs = 1000
                )
                delay(3000)
            }
        }
    }
    if (selectedEra == "15世紀" || selectedEra == "16世紀") {
        columbusPoints.forEachIndexed { index, point ->
            Marker(state = rememberMarkerState(position = point), title = columbusTitles[index])
        }
        Polyline(points = columbusPoints, color = Color.Blue, width = 6f)
    }
    if (selectedEra == "16世紀") {
        magellanPoints.forEachIndexed { index, point ->
            Marker(state = rememberMarkerState(position = point), title = magellanTitles[index])
        }
        Polyline(points = magellanPoints, color = Color.Blue, width = 6f)
    }

    val cookRoutePoints = listOf(
        LatLng(50.3715, -4.1426),   // イギリス・プリマス（出発）
        LatLng(-22.9068, -43.1729), // ブラジル・リオデジャネイロ
        LatLng(-33.0, -71.6333),    // チリ沖
        LatLng(-17.6509, -149.4260), // タヒチ
        LatLng(-38.6857, 176.0700), // ニュージーランド・ロトルア付近
        LatLng(-33.8688, 151.2093), // オーストラリア・シドニー
        LatLng(-34.3568, 18.4740),  // 喜望峰（南アフリカ）
        LatLng(51.2220, 1.4039)     // イギリス・ディール（帰還）
    )
    val cookRouteTitles = listOf(
        "クックの航路：プリマス（出発）",
        "クックの航路：リオデジャネイロ（補給）",
        "クックの航路：チリ沖通過",
        "クックの航路：タヒチ（観測）",
        "クックの航路：ニュージーランド探検",
        "クックの航路：オーストラリア東岸",
        "クックの航路：喜望峰経由",
        "クックの航路：ディール（帰還）"
    )
    LaunchedEffect(selectedEra) {
        if (selectedEra == "18世紀") {
            for (point in cookRoutePoints) {
                cameraPositionState.animate(
                    update = CameraUpdateFactory.newLatLngZoom(point, 4f),
                    durationMs = 1000
                )
                delay(3000)
            }
        }
    }
    if (selectedEra == "18世紀") {
        cookRoutePoints.forEachIndexed { index, point ->
            Marker(state = rememberMarkerState(position = point), title = cookRouteTitles[index])
        }
        Polyline(points = cookRoutePoints, color = Color.Blue, width = 6f)
    }

    val silkRoadPoints = listOf(
        LatLng(34.3416, 108.9398), // 西安（中国）
        LatLng(39.9042, 116.4074), // 北京（中国）
        LatLng(36.2048, 138.2529)  // 終点イメージ（日本）
    )
    val silkRoadTitles = listOf(
        "シルクロード：西安（中国）",
        "シルクロード：北京（中国）",
        "シルクロード：東アジア終点（日本）"
    )
    LaunchedEffect(selectedEra) {
        if (selectedEra == "紀元前1世紀" || selectedEra == "1世紀" || selectedEra == "2世紀") {
            for (point in silkRoadPoints) {
                cameraPositionState.animate(
                    update = CameraUpdateFactory.newLatLngZoom(point, 4f),
                    durationMs = 1000
                )
                delay(3000)
            }
        }
    }
    if (selectedEra == "紀元前1世紀" || selectedEra == "1世紀" || selectedEra == "2世紀") {
        silkRoadPoints.forEachIndexed { index, point ->
            Marker(state = rememberMarkerState(position = point), title = silkRoadTitles[index])
        }
        Polyline(points = silkRoadPoints, color = Color.Blue, width = 6f)
    }

    val atlanticTrianglePoints = listOf(
        LatLng(6.5244, 3.3792),      // ラゴス（奴隷積出港）
        LatLng(18.4655, -66.1057),   // カリブ海プランテーション地
        LatLng(51.5074, -0.1278)     // ロンドン（工業製品）
    )
    val atlanticTriangleTitles = listOf(
        "大西洋三角貿易：アフリカ（奴隷）",
        "大西洋三角貿易：カリブ海（砂糖など）",
        "大西洋三角貿易：イギリス（工業製品）"
    )
    if (selectedEra == "17世紀" || selectedEra == "18世紀") {
        atlanticTrianglePoints.forEachIndexed { index, point ->
            Marker(state = rememberMarkerState(position = point), title = atlanticTriangleTitles[index])
        }
        Polyline(points = atlanticTrianglePoints + atlanticTrianglePoints.first(), color = Color.Blue, width = 6f)
    }

    val pilgrimPoints = listOf(
        LatLng(52.3555, -1.1743),  // イギリス
        LatLng(41.9584, -70.6673)  // プリマス（マサチューセッツ）
    )
    val pilgrimTitles = listOf(
        "ピルグリム・ファーザーズの航路：イギリス（出発）",
        "ピルグリム・ファーザーズの航路：プリマス植民地（到着）"
    )
    LaunchedEffect(selectedEra) {
        if (selectedEra == "17世紀") {
            for (point in pilgrimPoints) {
                cameraPositionState.animate(
                    update = CameraUpdateFactory.newLatLngZoom(point, 4f),
                    durationMs = 1000
                )
                delay(3000)
            }
        }
    }
    if (selectedEra == "17世紀") {
        pilgrimPoints.forEachIndexed { index, point ->
            Marker(state = rememberMarkerState(position = point), title = pilgrimTitles[index])
        }
        Polyline(points = pilgrimPoints, color = Color.Blue, width = 6f)
    }
}
