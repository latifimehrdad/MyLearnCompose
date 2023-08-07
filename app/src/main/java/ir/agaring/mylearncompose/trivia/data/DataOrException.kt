package ir.agaring.mylearncompose.trivia.data

/**
 * Created by m-latifi on 8/7/2023.
 */

data class DataOrException<T, Boolean, E: Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var e: E? = null
)