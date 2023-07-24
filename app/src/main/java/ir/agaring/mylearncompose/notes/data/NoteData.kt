package ir.agaring.mylearncompose.notes.data

import ir.agaring.mylearncompose.notes.model.Note

/**
 * Created by m-latifi on 7/24/2023.
 */

class NoteDataSource{

    fun loadNotes(): List<Note>{
        return listOf(
            Note(title = "title1", description = "description1"),
            Note(title = "title2", description = "description2"),
            Note(title = "title3", description = "description3"),
            Note(title = "title4", description = "description4"),
            Note(title = "title5", description = "description5"),
            Note(title = "title6", description = "description6"),
            Note(title = "title7", description = "description7"),
            Note(title = "title8", description = "description8"),
            Note(title = "title9", description = "description9"),
            Note(title = "title10", description = "description10"),
        )
    }

}