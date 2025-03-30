package com.example.worldhistorymap.presentation.screen

import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.example.worldhistorymap.R
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MapScreen(
    navHostController: NavHostController
) {
    val context = LocalContext.current
    val locationPermissionState = rememberPermissionState(android.Manifest.permission.ACCESS_FINE_LOCATION)

    LaunchedEffect(Unit) {
        if (!locationPermissionState.status.isGranted) {
            locationPermissionState.launchPermissionRequest()
        }
    }

    if (locationPermissionState.status.isGranted) {
        ShowGoogleMap()
    } else {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("位置情報の許可が必要です")
        }
    }
    var searchQuery by rememberSaveable { mutableStateOf("") }
    val yorktownLocation = LatLng(37.2383, -76.5097)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(yorktownLocation, 15f)
    }
    val markerState = rememberMarkerState(position = yorktownLocation)

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
                icon = bitmapDescriptorFromDrawable(LocalContext.current, R.drawable.ic_independence),
                visible = true,
                onClick = { false }
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            SearchBarContainer(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )

            EraSelectedButton(onClick = {})

            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.space_16_dp)))

            InfoButton(onClick = {})

            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.space_16_dp)))
        }
    }
}

@Composable
private fun ShowGoogleMap() {
    val yorktownLocation = LatLng(37.2383, -76.5097)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(yorktownLocation, 15f)
    }
    val markerState = rememberMarkerState(position = yorktownLocation)

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
                icon = bitmapDescriptorFromDrawable(LocalContext.current, R.drawable.ic_independence),
                visible = true,
                onClick = { false }
            )
        }
    }
}

private fun bitmapDescriptorFromDrawable(context: Context, drawableResId: Int): BitmapDescriptor? {
    val drawable = ContextCompat.getDrawable(context, drawableResId)
    Log.d("MapScreen", "Drawable: $drawable")
    return if (drawable is BitmapDrawable) {
        val bitmap = drawable.bitmap
        BitmapDescriptorFactory.fromBitmap(bitmap)
    } else {
        Log.e("MapScreen", "Failed to convert drawable to BitmapDescriptor")
        null
    }
}


@Composable
private fun SearchBarContainer(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.padding(horizontal = dimensionResource(id = R.dimen.space_16_dp))) {
        SearchBar(query = query, onQueryChange = onQueryChange)
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
            androidx.compose.ui.graphics.Color.Gray.copy(alpha = 0.1f),
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
private fun EraSelectedButton(onClick: () -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.era_button),
        contentDescription = "Clickable Image",
        modifier = Modifier
            .size(56.dp)
            .clickable(onClick = onClick)
    )
}

@Composable
private fun InfoButton(onClick: () -> Unit) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Default.Info,
            contentDescription = "Info Button",
            tint = androidx.compose.ui.graphics.Color.Gray,
            modifier = Modifier
                .size(56.dp)
                .clickable(onClick = onClick)
        )
    }
}
