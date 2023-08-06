package ir.agaring.mylearncompose.notes.util

import androidx.room.TypeConverter
import java.util.UUID

/**
 * Created by m-latifi on 8/1/2023.
 */

class UUIDConverter {

    @TypeConverter
    fun fromUUID(uuid: UUID): String {
        return uuid.toString()
    }

    @TypeConverter
    fun uuidFromString(string: String): UUID?{
        return UUID.fromString(string)
    }

}