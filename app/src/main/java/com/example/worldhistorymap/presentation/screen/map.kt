package com.example.worldhistorymap.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.worldhistorymap.R
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(
    navHostController: NavHostController
) {
    // TODO : EraSelectedButton, InfoButtonの作成

    var searchQuery by rememberSaveable { mutableStateOf("") }
    val atasehir = LatLng(40.9971, 29.1007)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(atasehir, 15f)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            SearchBarContainer(
                query = searchQuery,
                onQueryChange = { searchQuery = it },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )

            // EraSelectedButton
            EraSelectedButton(onClick = {})
        }
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
            .size(48.dp)
            .clickable(onClick = onClick)
    )
}

