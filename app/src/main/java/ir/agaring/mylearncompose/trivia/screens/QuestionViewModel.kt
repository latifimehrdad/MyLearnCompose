package ir.agaring.mylearncompose.trivia.screens

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
 * Created by m-latifi on 8/7/2023.
 */

@HiltViewModel
class QuestionViewModel @Inject constructor(
    private val repository: QuestionRepository
): ViewModel() {


    val data: MutableState<DataOrException<
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
    }


    fun getTotalQuestionCount()  =
        data.value.data?.size ?: 0

}