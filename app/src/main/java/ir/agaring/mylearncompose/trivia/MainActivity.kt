package ir.agaring.mylearncompose.trivia

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import ir.agaring.mylearncompose.trivia.screens.QuestionViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: QuestionViewModel by viewModels()
            TriviaHome(viewModel = viewModel)
        }
    }
}


//-------------------------------------------------------------------------------------------------- TriviaHome
@Composable
fun TriviaHome(viewModel: QuestionViewModel) {
    Questions(viewModel = viewModel)
}
//-------------------------------------------------------------------------------------------------- TriviaHome


//-------------------------------------------------------------------------------------------------- Questions
@Composable
fun Questions(viewModel: QuestionViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading == false)
        Log.d("meri", "questions : ${questions?.size}")
    else
        Log.d("meri", "Loading")
}
//-------------------------------------------------------------------------------------------------- Questions
