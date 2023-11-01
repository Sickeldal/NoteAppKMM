package com.sickdev.noteappkmm.data.note

import com.sickdev.noteappkmm.database.NoteDatabase
import com.sickdev.noteappkmm.domain.note.Note
import com.sickdev.noteappkmm.domain.note.NoteDataSource
import com.sickdev.noteappkmm.domain.time.DateTimeUtil

class SqlDelightNoteDataSource(db: NoteDatabase) : NoteDataSource {

    private val queries = db.noteQueries

    override suspend fun insertNote(note: Note) {
        queries.inertNote(
            id = note.id,
            title = note.title,
            content = note.content,
            colorHex = note.colorHex,
            created = DateTimeUtil.toEpochMillis(note.created)
        )
    }

    override suspend fun getNoteById(id: Long): Note? {
        return queries.getNoteById(id).executeAsOneOrNull()?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries.getAllNotes().executeAsList().map { it.toNote() }
    }

    override suspend fun deleteNoteByID(id: Long) {
        queries.deleteNoteById(id)
    }
}