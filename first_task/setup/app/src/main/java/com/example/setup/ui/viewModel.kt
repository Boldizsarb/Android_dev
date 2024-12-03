package com.example.setup.ui
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


class MainViewModel: ViewModel(){
    // Shared state

    var seatNumber by mutableStateOf("26F")
    var destination by mutableStateOf("Ciudad de México")
    var mainText by mutableStateOf("Hola")
}