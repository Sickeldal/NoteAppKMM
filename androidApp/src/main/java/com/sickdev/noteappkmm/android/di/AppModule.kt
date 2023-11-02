package com.sickdev.noteappkmm.android.di

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import com.sickdev.noteappkmm.data.local.DatabaseDriverFactory
import com.sickdev.noteappkmm.data.note.SqlDelightNoteDataSource
import com.sickdev.noteappkmm.database.NoteDatabase
import com.sickdev.noteappkmm.domain.note.NoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun providesNoteDataSource(driver: SqlDriver): NoteDataSource {
        return SqlDelightNoteDataSource(NoteDatabase(driver))
    }
}