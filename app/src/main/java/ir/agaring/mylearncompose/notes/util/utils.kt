package ir.agaring.mylearncompose.notes.util

import java.sql.Date
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * Created by m-latifi on 8/1/2023.
 */

fun formatDate(time: Long): String{
    val date = Date(time)
    val format = SimpleDateFormat("EEE, d MMM hh:mm aaa", Locale.getDefault())
    return format.format(date)
}