package ir.agaring.mylearncompose.trivia.network

import ir.agaring.mylearncompose.trivia.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

/**
 * Created by m-latifi on 8/6/2023.
 */

@Singleton
interface QuestionApi {

    @GET("world.json")
    suspend fun getAllQuestions(): Question

}