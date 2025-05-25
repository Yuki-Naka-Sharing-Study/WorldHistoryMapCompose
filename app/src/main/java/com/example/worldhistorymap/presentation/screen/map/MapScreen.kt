package com.example.worldhistorymap.presentation.screen.map

import android.Manifest
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.worldhistorymap.R
import com.example.worldhistorymap.presentation.screen.map.markers.ArtMarkers
import com.example.worldhistorymap.presentation.screen.map.markers.BattleMarkers
import com.example.worldhistorymap.presentation.screen.map.markers.InventionMarkers
import com.example.worldhistorymap.util.bitmapDescriptorFromDrawable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapScreen(
    navHostController: NavHostController
) {
    val context = LocalContext.current
    val locationPermissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(0.0, 0.0), 2f)
    }
    var searchQuery by rememberSaveable { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf<String?>(null) }
    val eras = listOf(
        "紀元前3000年", "紀元前2000年", "紀元前1000年", "紀元前500年",
        "紀元前5世紀", "紀元前4世紀", "紀元前3世紀", "紀元前2世紀", "紀元前1世紀",
        "1世紀", "2世紀", "3世紀", "4世紀", "5世紀",
        "6世紀", "7世紀", "8世紀", "9世紀", "10世紀",
        "11世紀", "12世紀", "13世紀", "14世紀", "15世紀",
        "16世紀", "17世紀", "18世紀", "19世紀", "20世紀", "21世紀"
    )
    var selectedEra by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        if (!locationPermissionState.status.isGranted) {
            locationPermissionState.launchPermissionRequest()
        }
    }

    if (locationPermissionState.status.isGranted) {
        ShowGoogleMap()
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("位置情報の許可が必要です")
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            uiSettings = remember {
                MapUiSettings(
                    zoomControlsEnabled = true,
                    zoomGesturesEnabled = true,
                    scrollGesturesEnabled = true,
                    tiltGesturesEnabled = true
                )
            }
        ) {
            if (selectedCategory == "battle") {
                BattleMarkers(context, true)
            }

            if (selectedCategory == "invention") {
                InventionMarkers(context, true)
            }

            if (selectedCategory == "art") {
                ArtMarkers(context, true)
            }
        }

        Column {
            Row {
                SearchBarContainer(
                    query = searchQuery,
                    onQueryChange = { searchQuery = it },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.space_8_dp)))

                EraSelectedButton(
                    eras = eras,
                    selectedEra = selectedEra,
                    onEraSelected = { selectedEra = it }
                )

                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.space_8_dp)))

                InfoButton(onClick = {})

                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.space_8_dp)))
            }

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_4_dp)))

            Row {
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.space_8_dp)))

                // TODO:以下の複数のFilterChipを一つの関数で表示する案
                FilterChip(
                    onClick = {
                        selectedCategory = if (selectedCategory == "battle") null else "battle"
                    },
                    label = {
                        Text("")
                    },
                    selected = selectedCategory == "battle",
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.battle_field_icon),
                            contentDescription = "戦争アイコン",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                )

                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.space_8_dp)))

                FilterChip(
                    onClick = {
                        selectedCategory = if (selectedCategory == "invention") null else "invention"
                    },
                    selected = selectedCategory == "invention",
                    label = { Text("") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.invention_icon),
                            contentDescription = "発明アイコン",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                )

                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.space_8_dp)))

                FilterChip(
                    onClick = {
                        selectedCategory = if (selectedCategory == "art") null else "art"
                    },
                    selected = selectedCategory == "art",
                    label = { Text("") },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.art_icon),
                            contentDescription = "芸術アイコン",
                            modifier = Modifier.size(FilterChipDefaults.IconSize)
                        )
                    }
                )
            }
        }
    }
}

@Composable
private fun ShowGoogleMap() {
    val worldCenter = LatLng(0.0, 0.0)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(worldCenter, 2f)
    }
    val markerState = rememberMarkerState(position = worldCenter)

    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            uiSettings = remember {
                MapUiSettings(
                    zoomControlsEnabled = true,
                    zoomGesturesEnabled = true,
                    scrollGesturesEnabled = true,
                    tiltGesturesEnabled = true
                )
            }
        ) {
            Marker(
                state = markerState,
                title = "ヨークタウンの独立",
                icon = bitmapDescriptorFromDrawable(LocalContext.current, R.drawable.battle_field_icon),
                visible = true,
                onClick = { false }
            )
        }
    }
}

@Composable
private fun SearchBarContainer(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.padding(horizontal = dimensionResource(id = R.dimen.space_8_dp))) {
        SearchBar(
            query = query,
            onQueryChange = onQueryChange
        )
    }
}

@Composable
private fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit
) {
    val modifier = Modifier
        .fillMaxWidth()
        .background(
            Color.Gray.copy(alpha = 0.1f),
            shape = RoundedCornerShape(
                dimensionResource(
                    id = R.dimen.search_bar_background_rounded_corner_shape
                )
            )
        )
        .padding(dimensionResource(id = R.dimen.space_8_dp))

    Box(modifier = modifier) {
        TextField(
            value = query,
            onValueChange = onQueryChange,
            placeholder = {
                Text(
                    stringResource(id = R.string.search_by_text)
                )
            },
            leadingIcon = {
                Icon(
                    Icons.Default.Search,
                    contentDescription = stringResource(
                        id = R.string.content_description_search_icon
                    )
                )
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun EraSelectedButton(
    modifier: Modifier = Modifier,
    eras: List<String>,
    selectedEra: String?,
    onEraSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .size(56.dp)
            .clickable { expanded = true },
        contentAlignment = Alignment.Center
    ) {
        if (selectedEra == null) {
            Image(
                painter = painterResource(id = R.drawable.era_button),
                contentDescription = "時代選択ボタン",
                modifier = Modifier.size(40.dp)
            )
        } else {
            Text(
                text = selectedEra,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                maxLines = 2,
                lineHeight = 14.sp,
                modifier = Modifier.padding(horizontal = 4.dp)
            )
        }
    }

    if (expanded) {
        Dialog(onDismissRequest = { expanded = false }) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.White,
                modifier = Modifier.width(200.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("時代を選択", fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(8.dp))

                    val listState = rememberLazyListState()
                    val coroutineScope = rememberCoroutineScope()

                    LaunchedEffect(Unit) {
                        val index = selectedEra?.let { eras.indexOf(it) }?.coerceAtLeast(0) ?: 0
                        listState.scrollToItem(index)
                    }

                    Box(
                        modifier = Modifier
                            .height(160.dp)
                            .fillMaxWidth()
                    ) {
                        LazyColumn(state = listState) {
                            itemsIndexed(eras) { index, era ->
                                val isSelected = era == selectedEra
                                Text(
                                    text = era,
                                    fontSize = if (isSelected) 20.sp else 16.sp,
                                    color = if (isSelected) Color.Black else Color.Gray,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            onEraSelected(era)
                                            coroutineScope.launch {
                                                listState.animateScrollToItem(index)
                                            }
                                            expanded = false
                                        }
                                        .padding(vertical = 8.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    TextButton(onClick = { expanded = false }) {
                        Text("閉じる")
                    }
                }
            }
        }
    }
}

@Composable
private fun InfoButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = "Info Button",
            tint = Color.Gray,
            modifier = Modifier
                .size(56.dp)
                .clickable(onClick = onClick)
        )
    }
}
