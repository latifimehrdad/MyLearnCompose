package ir.agaring.mylearncompose.weather

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import ir.agaring.mylearncompose.trivia.screens.QuestionViewModel
import ir.agaring.mylearncompose.trivia.screens.TriviaHome
import ir.agaring.mylearncompose.ui.theme.MyLearnComposeTheme
import ir.agaring.mylearncompose.weather.navigation.WeatherNavigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherApp()
        }
    }
}


//-------------------------------------------------------------------------------------------------- WeatherApp
@Composable
fun WeatherApp() {
    MyLearnComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WeatherNavigation()
            }

        }
    }
}
//-------------------------------------------------------------------------------------------------- WeatherApp



