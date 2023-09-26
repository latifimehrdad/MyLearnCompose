package ir.agaring.mylearncompose.weather.screens.main

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ir.agaring.mylearncompose.weather.navigation.WeatherScreens
import ir.agaring.mylearncompose.weather.screens.setting.SettingViewModel
import ir.agaring.mylearncompose.weather.widgets.HumidityWindPressureRow
import ir.agaring.mylearncompose.weather.widgets.SunSetSunRise
import ir.agaring.mylearncompose.weather.widgets.WeatherAppBar
import ir.agaring.mylearncompose.weather.widgets.WeatherItem
import ir.agaring.mylearncompose.weather.widgets.WeatherStateImage

/**
 * Created by m-latifi on 8/31/2023.
 */

//-------------------------------------------------------------------------------------------------- MainScreen
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel(),
    city: String?,
    settingViewModel: SettingViewModel = hiltViewModel()
) {

    val unitFromDb = settingViewModel.unitList.collectAsState().value
    val unit by remember {
        mutableStateOf("imperial")
    }
    val isImperial by remember {
        mutableStateOf(false)
    }

    /*    val weatherData = produceState<DataOrException<ArrayList<QuestionItem>,
                Boolean,
                Exception>>(initialValue = DataOrException(loading = true)) {
            value = viewModel.getQuestion()
        }.value
        if (weatherData.loading == true) {
            CircularProgressIndicator()
        } else if (weatherData.data != null) {
            MainScaffold(questions = weatherData.data!!, navController = navController)
        }*/
    Log.d("meri", "city : ${city.toString()}")
    MainScaffold(navController = navController, city = city.toString())
}
//-------------------------------------------------------------------------------------------------- MainScreen


//-------------------------------------------------------------------------------------------------- MainScaffold
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(navController: NavController, city: String) {
    Scaffold(
        topBar = {
            WeatherAppBar(
                title = city,
                navController = navController,
                onAddActionClick = {
                    navController.navigate(route = WeatherScreens.SearchScreen.name)
                }
            ) {
                Log.d("meri", "Button Click")
            }
        }
    ) {
        MainContent(padding = it)
    }
}
//-------------------------------------------------------------------------------------------------- MainScaffold


//-------------------------------------------------------------------------------------------------- MainContent
@Composable
fun MainContent(padding: PaddingValues) {
    val imageUrl = "https://openweathermap.org/img/wn/10d.png"

    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Nov 29",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(6.dp)
        )


        Surface(
            modifier = Modifier
                .padding(4.dp)
                .size(200.dp),
            shape = CircleShape,
            color = Color(0xFFFFC400)
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                WeatherStateImage(imageUrl = imageUrl)

                Text(
                    text = "56°",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 30.sp
                )
                Text(
                    text = "Snow",
                    fontStyle = FontStyle.Italic
                )

            }

        }

        HumidityWindPressureRow()
        Divider()
        SunSetSunRise()

        Text(
            text = "This Week", style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            color = Color(0xFFEEF1EF),
            shape = RoundedCornerShape(size = 14.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(2.dp)
                    .fillMaxWidth(),
                contentPadding = PaddingValues(1.dp)
            ) {
                items(15) {
                    WeatherItem(imageUrl = imageUrl)
                }
            }
        }

    }

}
//-------------------------------------------------------------------------------------------------- MainContent

