package ir.agaring.mylearncompose.book.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.agaring.mylearncompose.book.screens.details.ReaderDetailsScreen
import ir.agaring.mylearncompose.book.screens.home.ReaderHomeScreen
import ir.agaring.mylearncompose.book.screens.login.ReaderLoginScreen
import ir.agaring.mylearncompose.book.screens.search.ReaderSearchScreen
import ir.agaring.mylearncompose.book.screens.splash.ReaderSplashScreen
import ir.agaring.mylearncompose.book.screens.stats.ReaderStatsScreen
import ir.agaring.mylearncompose.book.screens.update.ReaderUpdateScreen

/**
 * Created by m-latifi on 9/20/2023.
 */

@Composable
fun ReaderNavigation() {
    
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ReaderScreens.SplashScreen.name){

        composable(route = ReaderScreens.SplashScreen.name) {
            ReaderSplashScreen(navController = navController)
        }

        composable(route = ReaderScreens.ReaderHomeScreen.name) {
            ReaderHomeScreen(navController = navController)
        }

        composable(route = ReaderScreens.LoginScreen.name) {
            ReaderLoginScreen(navController = navController)
        }

        composable(route = ReaderScreens.SearchScreen.name) {
            ReaderSearchScreen(navController = navController)
        }

        composable(route = ReaderScreens.DetailScreen.name) {
            ReaderDetailsScreen(navController = navController)
        }

        composable(route = ReaderScreens.UpdateScreen.name) {
            ReaderUpdateScreen(navController = navController)
        }

        composable(route = ReaderScreens.ReaderStatsScreen.name) {
            ReaderStatsScreen(navController = navController)
        }

    }
    
}