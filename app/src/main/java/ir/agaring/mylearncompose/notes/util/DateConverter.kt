package ir.agaring.mylearncompose.notes.util

import android.util.Log
import androidx.room.TypeConverter
import java.util.Date

/**
 * Created by m-latifi on 8/1/2023.
 */

class DateConverter {

    @TypeConverter
    fun timeStampFromDate(date: Date): Long{
        return date.time
    }

    @TypeConverter
    fun dateFromTimeStamp(timestamp: Long): Date {
        return Date(timestamp)
    }

}