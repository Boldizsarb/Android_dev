package com.example.setup.ui
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavigation( mainViewModel: MainViewModel = viewModel()) { // view model as a parameter

    val navController = rememberNavController() // keeps track of the stack.


    NavHost(navController = navController, startDestination = "screen1") {
        // navhost mapping each route,

        composable("screen1") { // routes
            screen1(onNavigateToScreen2 = { navController.navigate("screen2") },
                viewModel = mainViewModel
            )
        }
        composable("screen2") {
            screen2(
                onNavigateBack = { navController.popBackStack() },
                viewModel = mainViewModel
            )
        }
    }
}