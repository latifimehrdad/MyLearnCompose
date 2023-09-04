package ir.agaring.mylearncompose.weather.screens.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.agaring.mylearncompose.trivia.data.DataOrException
import ir.agaring.mylearncompose.trivia.model.QuestionItem
import ir.agaring.mylearncompose.trivia.repository.QuestionRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by m-latifi on 8/31/2023.
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: QuestionRepository
): ViewModel(){


    suspend fun getQuestion(): DataOrException<
            ArrayList<QuestionItem>,
            Boolean,
            Exception> {
        return repository.getAllQuestion()
    }

/*    val data: MutableState<DataOrException<
            ArrayList<QuestionItem>,
            Boolean,
            Exception
            >> = mutableStateOf(DataOrException(null,true,Exception("")))

    init {
        getAllQuestion()
    }

    private fun getAllQuestion() {
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getAllQuestion()
            if (data.value.data.toString().isNotEmpty()){
                data.value.loading = false
            }
        }
    }*/

}