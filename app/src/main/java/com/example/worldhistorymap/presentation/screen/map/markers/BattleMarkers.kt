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

        "前5世紀" -> {
            Marker(
                state = rememberMarkerState(position = LatLng(37.9695, 23.7162)), // サラミス
                title = "ペルシア戦争（サラミスの海戦）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )
        }

        "前4世紀" -> {
            Marker(
                state = rememberMarkerState(position = LatLng(36.3650, 43.1450)), // イラク北部
                title = "アレクサンドロス大王の遠征（ガウガメラの戦い）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )
        }

        "前3世紀" -> {
            Marker(
                state = rememberMarkerState(position = LatLng(41.3083, 14.2581)), // カンネー（南イタリア）
                title = "ポエニ戦争（カンネーの戦い）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )
        }

        "8世紀" -> {
            Marker(
                state = rememberMarkerState(position = LatLng(47.3941, 0.6892)), // トゥール近郊
                title = "トゥール・ポワティエ間の戦い（イスラームの進出阻止）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )
        }

        "11世紀" -> {
            Marker(
                state = rememberMarkerState(position = LatLng(31.7683, 35.2137)), // エルサレム
                title = "第1回十字軍（エルサレム攻囲戦）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )
        }

        "15世紀" -> {
            Marker(
                state = rememberMarkerState(position = LatLng(48.8566, 2.3522)), // パリ
                title = "百年戦争（ジャンヌ・ダルクの活躍）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )
        }

        "17世紀" -> {
            Marker(
                state = rememberMarkerState(position = LatLng(50.0878, 14.4205)), // プラハ（ボヘミア）
                title = "三十年戦争（プラハの反乱）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )
        }

        "18世紀" -> {
            Marker(
                state = rememberMarkerState(position = LatLng(37.2383, -76.5097)), // ヨークタウン
                title = "アメリカ独立戦争（ヨークタウンの戦い）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )

            Marker(
                state = rememberMarkerState(position = LatLng(23.7000, 88.8833)), // プラッシー（インド）
                title = "七年戦争（プラッシーの戦い）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )
        }

        "19世紀" -> {
            Marker(
                state = rememberMarkerState(position = LatLng(39.8309, -77.2311)), // ゲティスバーグ
                title = "アメリカ南北戦争（ゲティスバーグの戦い）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )

            Marker(
                state = rememberMarkerState(position = LatLng(50.6806, 4.4128)), // ワーテルロー
                title = "ナポレオン戦争（ワーテルローの戦い）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )

            Marker(
                state = rememberMarkerState(position = LatLng(51.5074, -0.1278)), // ロンドン
                title = "アヘン戦争（イギリスの拠点）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )

            Marker(
                state = rememberMarkerState(position = LatLng(23.1291, 113.2644)), // 広州
                title = "アヘン戦争（清の拠点・広州）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )

            Marker(
                state = rememberMarkerState(position = LatLng(48.8566, 2.3522)), // パリ
                title = "普仏戦争（フランス側・パリ）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )

            Marker(
                state = rememberMarkerState(position = LatLng(52.5200, 13.4050)), // ベルリン
                title = "普仏戦争（プロイセン側・ベルリン）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )

            Marker(
                state = rememberMarkerState(position = LatLng(44.6167, 33.5250)), // セヴァストポリ
                title = "クリミア戦争（セヴァストポリ包囲戦）",
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

            Marker(
                state = rememberMarkerState(position = LatLng(29.3759, 47.9774)), // クウェート市
                title = "湾岸戦争（クウェート解放）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )

            Marker(
                state = rememberMarkerState(position = LatLng(16.4637, 107.5909)), // フエ市
                title = "ベトナム戦争（フエ市戦）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )
        }
    }
}
