package com.example.homework_6.Dagger

import android.content.Context
import com.example.homework_6.Model.INoteRepository
import com.example.homework_6.Model.NoteRepository
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

@Module
class RepositoryModule {

    @NotNull
    @Provides
    @Singleton
    fun provideNoteRepository(context : Context) : INoteRepository =
        NoteRepository(context)
}