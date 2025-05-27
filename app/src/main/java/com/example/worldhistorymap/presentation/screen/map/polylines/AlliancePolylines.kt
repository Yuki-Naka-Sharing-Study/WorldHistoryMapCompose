package com.example.worldhistorymap.presentation.screen.map.polylines

import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Polyline

// 三国同盟の関数
@Composable
fun TripleAlliancePolyline(
    selectedEra: String?
) {
    if (selectedEra == "19世紀") {
        val tripleAlliancePoints = listOf(
            LatLng(52.5200, 13.4050), // ドイツ（ベルリン）
            LatLng(48.2082, 16.3738), // オーストリア（ウィーン）
            LatLng(41.9028, 12.4964), // イタリア（ローマ）
            LatLng(52.5200, 13.4050)  // 戻って三角形を閉じる
        )
        Polyline(
            points = tripleAlliancePoints,
            color = Color.Red,
            width = 5f
        )
    }
}

// 三国協商の関数
@Composable
fun TripleEntentePolyline(
    selectedEra: String?
) {
    if (selectedEra == "19世紀") {
        val tripleEntentePoints = listOf(
            LatLng(51.5074, -0.1278), // イギリス（ロンドン）
            LatLng(48.8566, 2.3522),  // フランス（パリ）
            LatLng(59.9343, 30.3351), // ロシア（サンクトペテルブルク）
            LatLng(51.5074, -0.1278)  // 戻って三角形を閉じる
        )

        Polyline(
            points = tripleEntentePoints,
            color = Color.Blue,
            width = 5f
        )
    }
}

// 枢軸国
@Composable
fun AxisPowersPolyline(
    selectedEra: String?
) {
    if (selectedEra == "20世紀") {
        val axisPoints = listOf(
            LatLng(52.5200, 13.4050), // ドイツ（ベルリン）
            LatLng(41.9028, 12.4964), // イタリア（ローマ）
            LatLng(35.6895, 139.6917), // 日本（東京）
            LatLng(52.5200, 13.4050)  // 戻って三角形を閉じる
        )

        Polyline(
            points = axisPoints,
            color = Color.Red,
            width = 5f
        )
    }
}

// 連合国
@Composable
fun AlliedPowersPolyline(
    selectedEra: String?
) {
    if (selectedEra == "20世紀") {
        val alliedPoints = listOf(
            LatLng(51.5074, -0.1278), // イギリス（ロンドン）
            LatLng(48.8566, 2.3522),  // フランス（パリ）
            LatLng(38.9072, -77.0369), // アメリカ（ワシントンD.C.）
            LatLng(55.7558, 37.6173),  // ソ連（モスクワ）
            LatLng(51.5074, -0.1278)  // 戻ってロンドン
        )

        Polyline(
            points = alliedPoints,
            color = Color.Blue,
            width = 5f
        )
    }
}
