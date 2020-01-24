package com.example.homework_6.Model

interface INoteRepository {

    fun getAllNotes() : List<Note>?

    fun getNoteById(id : Long) : Note?

    fun addNewNote(note : Note) : Boolean

    fun deleteNote(id : Long) : Boolean

}