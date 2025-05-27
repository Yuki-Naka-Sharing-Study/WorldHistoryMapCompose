package com.example.worldhistorymap.presentation.screen.map.markers

import android.content.Context
import androidx.compose.runtime.Composable
import com.example.worldhistorymap.R
import com.example.worldhistorymap.util.bitmapDescriptorFromDrawable
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberMarkerState

@Composable
fun InventionMarkers(
    context: Context,
    selectedEra: String?
) {
    when (selectedEra) {

        // 15世紀 - 活版印刷
        "15世紀" -> {
            val mainz = LatLng(49.9980, 8.2711) // ドイツ・マインツ（グーテンベルク）
            Marker(
                state = rememberMarkerState(position = mainz),
                title = "活版印刷の発明（グーテンベルク）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 17世紀 - 顕微鏡の実用化
        "17世紀" -> {
            val delft = LatLng(52.0116, 4.3571) // オランダ・デルフト
            Marker(
                state = rememberMarkerState(position = delft),
                title = "顕微鏡の実用化（レーウェンフック）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 18世紀 - 蒸気機関
        "18世紀" -> {
            val england = LatLng(51.5074, -0.1278) // ロンドン（ワットの改良）
            Marker(
                state = rememberMarkerState(position = england),
                title = "蒸気機関の改良（ジェームズ・ワット）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 19世紀 - 電話・電球
        "19世紀" -> {
            val boston = LatLng(42.3601, -71.0589) // アメリカ・ボストン周辺
            val menloPark = LatLng(40.5451, -74.4652) // ニュージャージー州メンロパーク

            Marker(
                state = rememberMarkerState(position = boston),
                title = "電話の発明（ベル）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
            Marker(
                state = rememberMarkerState(position = menloPark),
                title = "電球の発明（エジソン）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 20世紀 - 飛行機・テレビ・抗生物質・原爆・コンピューター・インターネット
        "20世紀" -> {
            val kittyHawk = LatLng(36.0646, -75.7050) // ライト兄弟
            val london = LatLng(51.5074, -0.1278)     // ベアード / フレミング
            val losAlamos = LatLng(35.8800, -106.3031) // マンハッタン計画
            val upenn = LatLng(39.9522, -75.1932)      // ENIAC
            val ucla = LatLng(34.0689, -118.4452)      // ARPANET

            Marker(
                state = rememberMarkerState(position = kittyHawk),
                title = "飛行機の発明（ライト兄弟）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
            Marker(
                state = rememberMarkerState(position = london),
                title = "テレビの発明（ベアード）／ペニシリンの発見（フレミング）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
            Marker(
                state = rememberMarkerState(position = losAlamos),
                title = "原子爆弾の開発（ロスアラモス研究所）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
            Marker(
                state = rememberMarkerState(position = upenn),
                title = "コンピューター ENIAC（ペンシルベニア大学）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
            Marker(
                state = rememberMarkerState(position = ucla),
                title = "インターネットの原型 ARPANET（UCLA）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }
    }
}
