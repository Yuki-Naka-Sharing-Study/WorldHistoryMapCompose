package com.example.worldhistorymap.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.worldhistorymap.presentation.screen.MapScreen
import com.example.worldhistorymap.presentation.screen.SettingsScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Map.route,
        modifier = modifier
    ) {
        composable(BottomNavItem.Map.route) { MapScreen(navController) }
        composable(BottomNavItem.Settings.route) { SettingsScreen(navController) }
    }
}
