package ir.agaring.mylearncompose.book.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Login
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import ir.agaring.mylearncompose.R
import ir.agaring.mylearncompose.book.component.FabContent
import ir.agaring.mylearncompose.book.component.ReaderAppBar
import ir.agaring.mylearncompose.book.component.TitleSection
import ir.agaring.mylearncompose.book.model.MBook
import ir.agaring.mylearncompose.book.navigation.ReaderScreens

/**
 * Created by m-latifi on 9/20/2023.
 */

//-------------------------------------------------------------------------------------------------- ReaderHomeScreen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderHomeScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            ReaderAppBar(title = "A.Reader", navController = navController)
        },
        floatingActionButton = {
            FabContent {

            }
        }
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            HomeContent(navController = navController)
        }

    }

}
//-------------------------------------------------------------------------------------------------- ReaderHomeScreen


//-------------------------------------------------------------------------------------------------- HomeContent
@Composable
fun HomeContent(navController: NavController) {
    Column(
        modifier = Modifier.padding(2.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.align(alignment = Alignment.Start)
        ) {
            TitleSection(label = "Your reading \n" + "activity right now...")
            Spacer(modifier = Modifier.fillMaxWidth(0.7f))
            Column {
                Icon(imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Profile",
                    modifier = Modifier
                        .clickable {
                            navController.navigate(route = ReaderScreens.ReaderStatsScreen.name)
                        }
                        .size(45.dp),
                    tint = MaterialTheme.colorScheme.secondary
                )

                Text(
                    text = "Name",
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 15.sp,
                    color = Color.Red,
                    maxLines = 1,
                    overflow = TextOverflow.Clip
                )

                Divider()
            }
        }
        ListCard()
    }
}
//-------------------------------------------------------------------------------------------------- HomeContent


//-------------------------------------------------------------------------------------------------- ReadingRightNowArea
@Composable
fun ReadingRightNowArea(books: List<MBook>, navController: NavController) {

}
//-------------------------------------------------------------------------------------------------- ReadingRightNowArea


//-------------------------------------------------------------------------------------------------- ListCard
@Preview
@Composable
fun ListCard(
    book: MBook = MBook("a", "running", "Me and you", "hello word"),
    onPressDetail: (String) -> Unit = {}
) {

    val context = LocalContext.current
    val resources = context.resources
    val displayMetric = resources.displayMetrics
    val screensWidth = displayMetric.widthPixels / displayMetric.density
    val spacing = 10.dp


    Card(
        shape = RoundedCornerShape(29.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .padding(16.dp)
            .height(242.dp)
            .width(202.dp)
            .clickable {
                onPressDetail.invoke(book.title.toString())
            }
    ) {
        Column(
            modifier = Modifier.width(screensWidth.dp - (spacing * 2)),
            horizontalAlignment = Alignment.Start
        ) {
            Row(horizontalArrangement = Arrangement.Center) {

                Image(
                    painter = rememberAsyncImagePainter(model = null),
                    contentDescription = "",
                    modifier = Modifier
                        .height(140.dp)
                        .width(100.dp)
                        .padding(4.dp)
                )

                Spacer(modifier = Modifier.width(50.dp))

                Column() {

                }

            }
        }
    }

}
//-------------------------------------------------------------------------------------------------- ListCard





