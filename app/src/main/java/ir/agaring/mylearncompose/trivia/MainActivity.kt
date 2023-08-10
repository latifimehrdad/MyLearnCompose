package ir.agaring.mylearncompose.trivia

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import ir.agaring.mylearncompose.trivia.screens.QuestionViewModel
import ir.agaring.mylearncompose.trivia.screens.TriviaHome

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaHome()
        }
    }
}




