package com.reminder.mapautomotive.ui.main

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapWithInputsScreen(
    source: String,
    destination: String,
    onSourceChange: (String) -> Unit,
    onDestinationChange: (String) -> Unit,
    onStartClick: () -> Unit
) {
    if (isLandscape()) {
        MapWithInputsLandscape(
            source = source,
            destination = destination,
            onSourceChange = onSourceChange,
            onDestinationChange = onDestinationChange,
            onStartClick = onStartClick
        )
    } else {
        MapWithInputsPortrait(
            source = source,
            destination = destination,
            onSourceChange = onSourceChange,
            onDestinationChange = onDestinationChange,
            onStartClick = onStartClick
        )
    }
}


@Composable
fun MapWithInputsLandscape(
    source: String,
    destination: String,
    onSourceChange: (String) -> Unit,
    onDestinationChange: (String) -> Unit,
    onStartClick: () -> Unit
) {
    Row(modifier = Modifier.fillMaxSize()) {

        // Map takes left side
        GoogleMap(
            modifier = Modifier
                .weight(0.6f)
                .fillMaxHeight(),
            cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(LatLng(37.7749, -122.4194), 12f)
            }
        )

        // Inputs take right side
        Column(
            modifier = Modifier
                .weight(0.4f)
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = source,
                onValueChange = onSourceChange,
                label = { Text("Source") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = destination,
                onValueChange = onDestinationChange,
                label = { Text("Destination") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = onStartClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Start")
            }
        }
    }
}

@Composable
fun MapWithInputsPortrait(
    source: String,
    destination: String,
    onSourceChange: (String) -> Unit,
    onDestinationChange: (String) -> Unit,
    onStartClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {

        // Map occupies top part
        GoogleMap(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            cameraPositionState = rememberCameraPositionState {
                position = CameraPosition.fromLatLngZoom(LatLng(37.7749, -122.4194), 12f)
            }
        )

        // Inputs below map
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = source,
                onValueChange = onSourceChange,
                label = { Text("Source") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = destination,
                onValueChange = onDestinationChange,
                label = { Text("Destination") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = onStartClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Start")
            }
        }
    }
}



@Composable
fun isLandscape(): Boolean {
    val configuration = LocalConfiguration.current
    return configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
}
