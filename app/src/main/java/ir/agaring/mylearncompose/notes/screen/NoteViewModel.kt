package ir.agaring.mylearncompose.notes.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.agaring.mylearncompose.notes.data.NoteDataSource
import ir.agaring.mylearncompose.notes.model.Note
import ir.agaring.mylearncompose.notes.repository.NoteRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by m-latifi on 7/24/2023.
 */

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

//    var noteList = mutableStateListOf<Note>()

    init {
        viewModelScope.launch(IO) {
            repository.getAllNote().distinctUntilChanged()
                .collect{ listOfNote ->
                    if (listOfNote.isEmpty()){
                        Log.d("meri", "Empty list")
                    } else {
                        _noteList.value = listOfNote
                    }

                }
        }
    }

    fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note) }
    fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }
    fun removeNote(note: Note) = viewModelScope.launch { repository.deleteNote(note) }



}