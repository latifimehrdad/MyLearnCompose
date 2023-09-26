package ir.agaring.mylearncompose.book.navigation

/**
 * Created by m-latifi on 9/20/2023.
 */

enum class ReaderScreens {
    SplashScreen,
    LoginScreen,
    CreateAccountScreen,
    ReaderHomeScreen,
    SearchScreen,
    DetailScreen,
    UpdateScreen,
    ReaderStatsScreen;
    companion object {
        fun fromRoute(route: String?): ReaderScreens =
            when(route?.substringBefore("/")){
                SplashScreen.name -> SplashScreen
                LoginScreen.name -> LoginScreen
                CreateAccountScreen.name -> CreateAccountScreen
                SearchScreen.name -> SearchScreen
                ReaderHomeScreen.name -> ReaderHomeScreen
                DetailScreen.name -> DetailScreen
                UpdateScreen.name -> UpdateScreen
                ReaderStatsScreen.name -> ReaderStatsScreen
                null -> LoginScreen
                else -> LoginScreen
            }
    }
}