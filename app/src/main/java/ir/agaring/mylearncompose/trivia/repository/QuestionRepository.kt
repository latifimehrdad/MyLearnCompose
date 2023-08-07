package ir.agaring.mylearncompose.trivia.repository

import android.util.Log
import ir.agaring.mylearncompose.trivia.data.DataOrException
import ir.agaring.mylearncompose.trivia.model.QuestionItem
import ir.agaring.mylearncompose.trivia.network.QuestionApi
import javax.inject.Inject

/**
 * Created by m-latifi on 8/7/2023.
 */

class QuestionRepository @Inject constructor(private val api: QuestionApi) {

    private val dataOrException = DataOrException<
            ArrayList<QuestionItem>,
            Boolean,
            Exception
            >()

    suspend fun getAllQuestion(): DataOrException<
            ArrayList<QuestionItem>,
            Boolean,
            Exception>{

        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty())
                dataOrException.loading = false

        } catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("meri", "getAllQuestion : ${dataOrException.e?.localizedMessage}")
        }

        return dataOrException
    }


}