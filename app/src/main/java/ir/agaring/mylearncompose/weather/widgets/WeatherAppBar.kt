package ir.agaring.mylearncompose.weather.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ir.agaring.mylearncompose.notes.util.AppColors

/**
 * Created by m-latifi on 9/4/2023.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherAppBar(
    title: String = "title",
    icon: ImageVector? = null,
    isMainScreen: Boolean = true,
    navController: NavController,
    onAddActionClick: () -> Unit = {},
    onButtonClick: () -> Unit = {}){

    TopAppBar(
        title = { Text(
            text = title,
            color = MaterialTheme.colorScheme.onBackground,
            style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 15.sp)
        ) },
        actions = {
                  if (isMainScreen){
                      IconButton(onClick = { /*TODO*/ }) {
                          Icon(imageVector = Icons.Default.Search, contentDescription = "search")
                      }
                      IconButton(onClick = { /*TODO*/ }) {
                          Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = "MoreVert")
                      }
                  } else Box{}
        },
        navigationIcon = {
                         if (icon != null){
                             Icon(
                                 imageVector = icon, contentDescription = "navigation",
                                 tint = MaterialTheme.colorScheme.onBackground,
                                 modifier = Modifier.clickable {
                                     onButtonClick.invoke()
                                 }
                             )
                         }
        },

        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Transparent,
        ),
    )

}