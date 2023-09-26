package ir.agaring.mylearncompose.book

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import ir.agaring.mylearncompose.book.navigation.ReaderNavigation
import ir.agaring.mylearncompose.ui.theme.MyLearnComposeTheme

/**
 * Created by m-latifi on 9/18/2023.
 */

//-------------------------------------------------------------------------------------------------- MainActivity
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookApp()
        }
    }
}
//-------------------------------------------------------------------------------------------------- MainActivity


//-------------------------------------------------------------------------------------------------- BookApp
@Composable
fun BookApp() {
    MyLearnComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ReaderNavigation()
            }
        }
    }
}
//-------------------------------------------------------------------------------------------------- BookApp

