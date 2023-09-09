package ir.agaring.mylearncompose.weather.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import ir.agaring.mylearncompose.R

/**
 * Created by m-latifi on 9/9/2023.
 */

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



//-------------------------------------------------------------------------------------------------- SunSetSunRise
@Composable
fun SunSetSunRise() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, bottom = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.sunrise), contentDescription = "sunrise",
                modifier = Modifier.size(30.dp)
            )

            Text(text = "11:34 AM", style = MaterialTheme.typography.labelMedium)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "11:34 AM", style = MaterialTheme.typography.labelMedium)

            Image(
                painter = painterResource(id = R.drawable.sunrise), contentDescription = "sunrise",
                modifier = Modifier.size(30.dp)
            )
        }

    }
}
//-------------------------------------------------------------------------------------------------- SunSetSunRise




//-------------------------------------------------------------------------------------------------- WeatherItem
@Composable
fun WeatherItemMehrdad(imageUrl: String) {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(80.dp),
        shape = RoundedCornerShape(
            topStart = 50.dp,
            bottomStart = 50.dp,
            topEnd = 5.dp,
            bottomEnd = 50.dp
        )
    ) {

        Row(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(text = "Fri", style = MaterialTheme.typography.titleMedium)

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

            Text(
                text = "light rain",
                style = MaterialTheme.typography.labelMedium,
            )

            Text(
                text = "43°37°",
                style = MaterialTheme.typography.titleMedium,
            )

        }
    }
}
//-------------------------------------------------------------------------------------------------- WeatherItem


//-------------------------------------------------------------------------------------------------- WeatherItem
@Composable
fun WeatherItem(imageUrl: String) {
    Surface(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth(),
        shape = CircleShape.copy(topEnd = CornerSize(5.dp)),
        color = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Fri",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = 5.dp))

            WeatherStateImage(imageUrl = imageUrl)

            Surface(
                modifier = Modifier.padding(1.dp),
                shape = CircleShape,
                color = Color(0xFFFFC400)
            ) {

                Text(
                    text = "Raining",
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.labelMedium
                )
            }

            Text(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue.copy(alpha = 0.7f),
                        fontWeight = FontWeight.SemiBold
                    )
                ) {
                    append("43°")
                }
                withStyle(
                    style = SpanStyle(
                        color = Color.LightGray,
                        fontWeight = FontWeight.SemiBold
                    )
                ) {
                    append("36°")
                }

            }
            )

        }

    }
}
//-------------------------------------------------------------------------------------------------- WeatherItem