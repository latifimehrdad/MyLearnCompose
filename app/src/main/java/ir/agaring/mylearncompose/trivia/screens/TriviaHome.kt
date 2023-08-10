package ir.agaring.mylearncompose.trivia.screens

import androidx.compose.runtime.Composable
import ir.agaring.mylearncompose.trivia.component.Questions
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * Created by m-latifi on 8/10/2023.
 */

//-------------------------------------------------------------------------------------------------- TriviaHome
@Composable
fun TriviaHome() {
    val viewModel: QuestionViewModel = viewModel()
    Questions(viewModel = viewModel)
}
//-------------------------------------------------------------------------------------------------- TriviaHome


