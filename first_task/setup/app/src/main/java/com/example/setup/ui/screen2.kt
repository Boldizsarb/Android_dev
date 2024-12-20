package com.example.setup.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun screen2(onNavigateBack: () -> Unit, viewModel: MainViewModel) {
    SharedLayout(
        seatNumber = viewModel.seatNumber,
        destination = viewModel.destination,
        mainText = viewModel.mainText,
        onButtonClick = {
            onNavigateBack()
        },
        showButtons = true
    )
}