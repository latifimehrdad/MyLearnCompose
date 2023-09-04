package ir.agaring.mylearncompose.weather.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.agaring.mylearncompose.weather.screens.main.MainScreen
import ir.agaring.mylearncompose.weather.screens.main.MainViewModel
import ir.agaring.mylearncompose.weather.screens.splash.WeatherSplashScreen

/**
 * Created by m-latifi on 8/17/2023.
 */

@Composable
fun WeatherNavigation() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = WeatherScreens.SplashScreen.name
    ) {

        composable(route = WeatherScreens.SplashScreen.name) {
            WeatherSplashScreen(navController = navController)
        }

        composable(route = WeatherScreens.MainScreen.name) {
            val viewModel = hiltViewModel<MainViewModel>()
            MainScreen(navController = navController, viewModel = viewModel)
        }

    }

}