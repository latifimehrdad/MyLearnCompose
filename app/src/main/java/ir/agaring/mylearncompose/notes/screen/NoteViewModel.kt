package ir.agaring.mylearncompose.notes.screen

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import ir.agaring.mylearncompose.notes.data.NoteDataSource
import ir.agaring.mylearncompose.notes.model.Note

/**
 * Created by m-latifi on 7/24/2023.
 */

class NoteViewModel: ViewModel() {

    var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(NoteDataSource().loadNotes())
    }

    fun addNote(note: Note){
        noteList.add(note)
    }

    fun removeNote(note: Note){
        noteList.remove(note)
    }


    fun getAllNotes(): List<Note>{
        return noteList
    }

}