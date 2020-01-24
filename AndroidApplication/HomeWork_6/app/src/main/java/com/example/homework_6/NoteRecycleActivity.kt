package com.example.homework_6

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.homework_6.Model.Note
import com.example.homework_6.Model.NoteRepository

class NoteRecycleActivity : AppCompatActivity(), Listener {

    private val NOTE_TEXT : String = "TEXT"
    private val NOTE_IMAGE : String = "IMAGE"

    private var repository : NoteRepository? = null

    override fun onNoteClick(id: Long) {
        val note = repository!!.getNoteById(id)
        val intent = Intent(this, ShowNoteActivity::class.java)
        intent.putExtra(NOTE_TEXT, note.text)
        intent.putExtra(NOTE_IMAGE, note.drawableRes)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        this.repository = NoteRepository(this)

        val recycleView = findViewById<RecyclerView>(R.id.notes_RecycleView)
        recycleView.layoutManager = LinearLayoutManager(this) // проверка ориентации
        recycleView.setHasFixedSize(true)
        recycleView.recycledViewPool.setMaxRecycledViews(0, 6)

        val adapter = NoteAdapter()
        adapter.notesList = repository!!.getAllNotes()
        adapter.listener = this
        recycleView.adapter = adapter
    }

}



