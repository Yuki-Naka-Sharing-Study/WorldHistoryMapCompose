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

        // 紀元前4千年 - 文字の発明（楔形文字）
        "紀元前4000年" -> {
            val uruk = LatLng(31.3213, 45.6417) // メソポタミア・ウルク
            Marker(
                state = rememberMarkerState(position = uruk),
                title = "文字の発明（シュメール・楔形文字）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 紀元前3千年 - 車輪の発明（メソポタミア・ウル）
        "紀元前3000年" -> {
            val ur = LatLng(30.9640, 46.1051) // ウル（現在のイラク）
            Marker(
                state = rememberMarkerState(position = ur),
                title = "車輪の発明（シュメール）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 紀元前2千年 - 天文観測の体系化（古代エジプト）
        "紀元前2000年" -> {
            val thebes = LatLng(25.7188, 32.6573) // テーベ
            Marker(
                state = rememberMarkerState(position = thebes),
                title = "天文観測の体系化（古代エジプト）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 紀元前1000年 - 鉄器の使用
        "紀元前1000年" -> {
            val hattusa = LatLng(40.0267, 34.6144) // ヒッタイト首都
            Marker(
                state = rememberMarkerState(position = hattusa),
                title = "鉄器の普及（ヒッタイト）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 紀元前3世紀 - アルキメデスの螺旋ポンプ
        "紀元前3世紀" -> {
            val syracuse = LatLng(37.0755, 15.2866) // シラクサ（現イタリア・シチリア）
            Marker(
                state = rememberMarkerState(position = syracuse),
                title = "アルキメデスの螺旋ポンプ（古代ギリシャ）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 7世紀 - 天体観測装置（イスラム科学）
        "7世紀" -> {
            val damascus = LatLng(33.5138, 36.2765)
            Marker(
                state = rememberMarkerState(position = damascus),
                title = "天体観測装置の発展（イスラム科学）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 9世紀 - 木版印刷（中国・唐）
        "9世紀" -> {
            val changan = LatLng(34.3416, 108.9398) // 長安
            Marker(
                state = rememberMarkerState(position = changan),
                title = "木版印刷の発明（唐代中国）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 10世紀 - 紙の製造技術の伝播（イスラム）
        "10世紀" -> {
            val baghdad = LatLng(33.3152, 44.3661) // バグダード
            Marker(
                state = rememberMarkerState(position = baghdad),
                title = "紙の技術の伝播（中国→イスラム）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 11世紀 - 火薬の軍事利用（宋）
        "11世紀" -> {
            val kaifeng = LatLng(34.7972, 114.3076) // 開封（宋の首都）
            Marker(
                state = rememberMarkerState(position = kaifeng),
                title = "火薬の軍事利用（宋代中国）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )

            val cluny = LatLng(46.4354, 4.6619) // クロニー修道院
            Marker(
                state = rememberMarkerState(position = cluny),
                title = "水車の実用化（中世修道院）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 12世紀 - 羅針盤の航海応用
        "12世紀" -> {
            val fuzhou = LatLng(26.0745, 119.2965) // 福建省・福州（航海の中心）
            Marker(
                state = rememberMarkerState(position = fuzhou),
                title = "羅針盤の航海応用（宋代中国）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 13世紀 - 眼鏡の発明（凸レンズ）
        "13世紀" -> {
            val pisa = LatLng(43.7228, 10.4017) // イタリア・ピサ
            Marker(
                state = rememberMarkerState(position = pisa),
                title = "眼鏡の発明（凸レンズ、イタリア）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 14世紀 - 機械式時計（都市の時計塔）
        "14世紀" -> {
            val florence = LatLng(43.7696, 11.2558) // フィレンツェ
            Marker(
                state = rememberMarkerState(position = florence),
                title = "機械式時計の発明（ヨーロッパ中世都市）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 15世紀 - 活版印刷・カラベル船の設計
        "15世紀" -> {
            val mainz = LatLng(49.9980, 8.2711) // ドイツ・マインツ（グーテンベルク）
            Marker(
                state = rememberMarkerState(position = mainz),
                title = "活版印刷の発明（グーテンベルク）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )

            val florence = LatLng(43.7696, 11.2558)
            Marker(
                state = rememberMarkerState(position = florence),
                title = "遠近法の確立（ブルネレスキ）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )

            val lisbon = LatLng(38.7169, -9.1399) // ポルトガル・リスボン
            Marker(
                state = rememberMarkerState(position = lisbon),
                title = "カラベル船の設計（ポルトガル）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 16世紀 - 鉄砲の使用（火縄銃）
        "16世紀" -> {
            val tanegashima = LatLng(30.7353, 131.0020) // 種子島
            Marker(
                state = rememberMarkerState(position = tanegashima),
                title = "鉄砲の伝来と普及（種子島）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 17世紀 - 顕微鏡の実用化・振り子時計
        "17世紀" -> {
            val delft = LatLng(52.0116, 4.3571) // オランダ・デルフト
            Marker(
                state = rememberMarkerState(position = delft),
                title = "顕微鏡の実用化（レーウェンフック）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )

            val hague = LatLng(52.0705, 4.3007) // オランダ・デン・ハーグ（ホイヘンス）
            Marker(
                state = rememberMarkerState(position = hague),
                title = "振り子時計の発明（ホイヘンス）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 18世紀 - 蒸気機関・スピニング・ジェニーの発明
        "18世紀" -> {
            val england = LatLng(51.5074, -0.1278) // ロンドン（ワットの改良）
            Marker(
                state = rememberMarkerState(position = england),
                title = "蒸気機関の改良（ジェームズ・ワット）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )

            val blackburn = LatLng(53.7445, -2.4769) // イギリス・ブラックバーン
            Marker(
                state = rememberMarkerState(position = blackburn),
                title = "スピニング・ジェニーの発明（ハーグリーヴス）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 19世紀 - 電話・電球
        "19世紀" -> {
            val boston = LatLng(42.3601, -71.0589) // アメリカ・ボストン周辺
            Marker(
                state = rememberMarkerState(position = boston),
                title = "電話の発明（ベル）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )

            val menloPark = LatLng(40.5451, -74.4652) // ニュージャージー州メンロパーク
            Marker(
                state = rememberMarkerState(position = menloPark),
                title = "電球の発明（エジソン）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )

            val paris = LatLng(48.8566, 2.3522) // フランス・パリ
            Marker(
                state = rememberMarkerState(position = paris),
                title = "写真技術の発明（ダゲール）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 20世紀 - 飛行機・テレビ・抗生物質・原爆・コンピューター・インターネット
        "20世紀" -> {
            val kittyHawk = LatLng(36.0646, -75.7050) // ライト兄弟
            Marker(
                state = rememberMarkerState(position = kittyHawk),
                title = "飛行機の発明（ライト兄弟）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )

            val london = LatLng(51.5074, -0.1278)     // ベアード / フレミング
            Marker(
                state = rememberMarkerState(position = london),
                title = "テレビの発明（ベアード）／ペニシリンの発見（フレミング）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )

            val bologna = LatLng(44.4949, 11.3426) // イタリア・ボローニャ
            Marker(
                state = rememberMarkerState(position = bologna),
                title = "ラジオ通信の実用化（マルコーニ）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )

            val losAlamos = LatLng(35.8800, -106.3031) // マンハッタン計画
            Marker(
                state = rememberMarkerState(position = losAlamos),
                title = "原子爆弾の開発（ロスアラモス研究所）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )

            val upenn = LatLng(39.9522, -75.1932)      // ENIAC
            Marker(
                state = rememberMarkerState(position = upenn),
                title = "コンピューター ENIAC（ペンシルベニア大学）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )

            val ucla = LatLng(34.0689, -118.4452)      // ARPANET
            Marker(
                state = rememberMarkerState(position = ucla),
                title = "インターネットの原型 ARPANET（UCLA）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }

        // 21世紀 - スマートフォン
        "21世紀" -> {
            val applePark = LatLng(37.3349, -122.0090) // Apple Park（米カリフォルニア）
            Marker(
                state = rememberMarkerState(position = applePark),
                title = "スマートフォンの普及（Apple）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )

            val openAI = LatLng(37.7749, -122.4194) // サンフランシスコ
            Marker(
                state = rememberMarkerState(position = openAI),
                title = "人工知能の革新（OpenAIなど）",
                icon = bitmapDescriptorFromDrawable(context, R.drawable.invention_icon),
                visible = true,
                onClick = { false }
            )
        }
    }
}
