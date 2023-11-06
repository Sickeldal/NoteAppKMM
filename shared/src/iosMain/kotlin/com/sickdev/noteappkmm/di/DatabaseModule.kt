package com.sickdev.noteappkmm.di

import com.sickdev.noteappkmm.data.local.DatabaseDriverFactory
import com.sickdev.noteappkmm.data.note.SqlDelightNoteDataSource
import com.sickdev.noteappkmm.database.NoteDatabase
import com.sickdev.noteappkmm.domain.note.NoteDataSource

class DatabaseModule {

    private val factory by lazy { DatabaseDriverFactory() }
    val noteDataSource: NoteDataSource by lazy {
        SqlDelightNoteDataSource(NoteDatabase(factory.createDriver()))
    }
}