package ir.agaring.mylearncompose.weather.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ir.agaring.mylearncompose.weather.screens.SettingsScreen
import ir.agaring.mylearncompose.weather.screens.about.AboutScreen
import ir.agaring.mylearncompose.weather.screens.favorite.FavoriteScreen
import ir.agaring.mylearncompose.weather.screens.main.MainScreen
import ir.agaring.mylearncompose.weather.screens.main.MainViewModel
import ir.agaring.mylearncompose.weather.screens.search.SearchScreen
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

        //www.google.com/cityname="seattle"
        val route = WeatherScreens.MainScreen.name
        composable(route = "$route/{city}",
            arguments = listOf(
                navArgument(name = "city") {
                    type = NavType.StringType
                }
            )) {navBack ->
            navBack.arguments?.getString("city").let { city ->
                val viewModel = hiltViewModel<MainViewModel>()
                MainScreen(
                    navController = navController,
                    viewModel = viewModel,
                    city = city)
            }
        }

        composable(route = WeatherScreens.SearchScreen.name) {
            SearchScreen(navController = navController)
        }


        composable(route = WeatherScreens.AboutScreen.name) {
            AboutScreen(navController = navController)
        }


        composable(route = WeatherScreens.FavoriteScreen.name) {
            FavoriteScreen(navController = navController)
        }



        composable(route = WeatherScreens.SettingsScreen.name) {
            SettingsScreen(navController = navController)
        }

    }

}