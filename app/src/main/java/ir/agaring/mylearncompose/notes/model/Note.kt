package ir.agaring.mylearncompose.notes.model

import java.time.LocalDateTime
import java.util.UUID

/**
 * Created by m-latifi on 7/24/2023.
 */

data class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String,
    val entryDate: LocalDateTime = LocalDateTime.now()
)
