package ir.agaring.mylearncompose.notes.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.agaring.mylearncompose.notes.data.NoteDatabase
import ir.agaring.mylearncompose.notes.data.NoteDatabaseDao
import javax.inject.Singleton

/**
 * Created by m-latifi on 7/24/2023.
 */

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideNotesDao(noteDatabase: NoteDatabase): NoteDatabaseDao = noteDatabase.noteDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): NoteDatabase =
        Room.databaseBuilder(context, NoteDatabase::class.java, "notest_db")
            .fallbackToDestructiveMigration()
            .build()

}