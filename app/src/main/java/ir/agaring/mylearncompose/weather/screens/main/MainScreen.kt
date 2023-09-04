package ir.agaring.mylearncompose.weather.screens.main

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import ir.agaring.mylearncompose.R
import ir.agaring.mylearncompose.weather.widgets.WeatherAppBar

/**
 * Created by m-latifi on 8/31/2023.
 */

//-------------------------------------------------------------------------------------------------- MainScreen
@Composable
fun MainScreen(navController: NavController, viewModel: MainViewModel = hiltViewModel()) {
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
    MainScaffold(navController = navController)
}
//-------------------------------------------------------------------------------------------------- MainScreen


//-------------------------------------------------------------------------------------------------- MainScaffold
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(navController: NavController) {
    Scaffold(
        topBar = {
            WeatherAppBar(
                title = "HelLo ghfh",
                navController = navController,
                icon = Icons.Default.ArrowBack
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

    }

}
//-------------------------------------------------------------------------------------------------- MainContent


//-------------------------------------------------------------------------------------------------- WeatherStateImage
@Composable
fun WeatherStateImage(imageUrl: String) {
    Image(
        modifier = Modifier.size(80.dp),
        painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(
                context = LocalContext.current
            )
                .data(imageUrl)
                .crossfade(true)
                .transformations(CircleCropTransformation())
                .build()
        ),
        contentDescription = "Image Movie"
    )
}
//-------------------------------------------------------------------------------------------------- WeatherStateImage


//-------------------------------------------------------------------------------------------------- HumidityWindPressureRow
@Composable
fun HumidityWindPressureRow() {

    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row(modifier = Modifier.padding(4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.humidity),
                contentDescription = "humidity",
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "63%",
                style = MaterialTheme.typography.labelMedium
            )
        }

        Row(modifier = Modifier.padding(4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.pressure),
                contentDescription = "pressure",
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "100 psi",
                style = MaterialTheme.typography.labelMedium
            )
        }

        Row(modifier = Modifier.padding(4.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.wind),
                contentDescription = "wind",
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = "63 mph",
                style = MaterialTheme.typography.labelMedium
            )
        }

    }

}
//-------------------------------------------------------------------------------------------------- HumidityWindPressureRow