package ir.agaring.mylearncompose.notes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.agaring.mylearncompose.notes.model.Note
import ir.agaring.mylearncompose.notes.util.DateConverter
import ir.agaring.mylearncompose.notes.util.UUIDConverter

/**
 * Created by m-latifi on 7/30/2023.
 */

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDatabaseDao
}