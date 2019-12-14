package com.example.homework_6.Model

import android.content.Context

import java.io.File
import java.util.*

object NoteRepository{

    private fun generateRandomDate() : Date {
        var random = Random()
        return Date(2000 + random.nextInt(20), 1 +  random.nextInt(11), 1 + random.nextInt(29))
    }

    public var notesList : MutableCollection<Note> = mutableListOf<Note>()

    // side effect function
    public fun Initialize ()
            = File("notes.txt")
            .bufferedReader()
            .readLines()
            .fold(0L, {acc, noteText ->
                notesList.add(Note(acc, generateRandomDate(), noteText, 1)); return acc + 1})

    public fun getNoteById(id : Long) = notesList.firstOrNull { note -> note.id == id }
}