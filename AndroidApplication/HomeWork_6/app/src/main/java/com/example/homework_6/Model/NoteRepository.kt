package com.example.homework_6.Model

import android.content.Context
import com.example.homework_6.R
import java.util.*
import kotlin.random.Random

class NoteRepository(context: Context) {

    private var _notes : MutableList<Note> = mutableListOf()

    init {

        var elems = context.assets.open("notes.txt")
            .bufferedReader()
            .readText().split("\n\n")
            .fold(0L) { acc, s ->
                if(s == "")
                    acc
                _notes.add(Note(acc, generateRandomDate(), s, selectDrawable( acc % 4 + 1)))
                acc + 1
            }
        /*_notes.add(Note(1, generateRandomDate(), "Some random text", 1))
        _notes.add(Note(2, generateRandomDate(), "Some random text 2", 1))*/
    }

    private fun generateRandomDate() : Date=
        Date(Random.nextInt(2000, 2020), Random.nextInt(1, 13), Random.nextInt(1, 30))

    private fun selectDrawable(id : Long) =
        when(id)
        {
            1L -> R.drawable.cat1
            2L -> R.drawable.cat2
            3L -> R.drawable.cat3
            4L -> R.drawable.cat4
            else -> R.drawable.ic_launcher_foreground
        }

    public fun getAllNotes() = _notes.toList()

    public fun getNoteById(id : Long) : Note = _notes.first { note -> note.id == id }

}