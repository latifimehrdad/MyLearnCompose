package ir.agaring.mylearncompose.movie.navigation

import java.lang.IllegalArgumentException

/**
 * Created by m-latifi on 7/19/2023.
 */

//www.google.com/sign_in
enum class MovieScreens {
    HomeScreen,
    DetailsScreen;
    companion object {
        fun fromRoute(route: String?): MovieScreens =
            when(route?.substringBefore("/")){
               HomeScreen.name -> HomeScreen
               DetailsScreen.name -> DetailsScreen
               null -> HomeScreen
               else -> throw IllegalArgumentException("Route $route is not recognize")
            }
    }
}