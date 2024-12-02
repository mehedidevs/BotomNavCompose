package com.mehedi.bottomnavcompose.presentation.bottomnav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mehedi.bottomnavcompose.presentation.bottomnav.screens.HomeScreen
import com.mehedi.bottomnavcompose.presentation.bottomnav.screens.ProfileScreen
import com.mehedi.bottomnavcompose.presentation.bottomnav.screens.SettingsScreen

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route,
        modifier = modifier
    ) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.Profile.route) {
            ProfileScreen()
        }
        composable(BottomNavItem.Settings.route) {
            SettingsScreen()
        }
    }
}