package com.example.setup.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.setup.ui.theme.DarkRed


@Composable
fun screen1(onNavigateToScreen2: () -> Unit, viewModel: MainViewModel){
    Box(  // wrapping it around a box and making the whole thing clickable
        modifier = Modifier
            .fillMaxSize()
            .clickable { // whole screen is clickable

                onNavigateToScreen2()
            }
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color.Red, DarkRed)
                )
            )
    ) {
        SharedLayout(
            seatNumber = viewModel.seatNumber,
            destination = viewModel.destination,
            mainText = viewModel.mainText,
            onButtonClick = {},
            showButtons = false // No buttons for screen1
        )
    }
}