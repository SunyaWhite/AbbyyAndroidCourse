package com.example.homework_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_6.Dagger.AppModule
import com.example.homework_6.Dagger.DaggerRepositoryComponent
import com.example.homework_6.Dagger.RepositoryModule
import com.example.homework_6.Model.INoteRepository
import javax.inject.Inject

class NoteRecycleActivity : AppCompatActivity(), Listener {

    private val NOTE_TEXT : String = "TEXT"
    private val NOTE_IMAGE : String = "IMAGE"

    @Inject
    lateinit var repository : INoteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)

        buildRepository()

        val recycleView = findViewById<RecyclerView>(R.id.notes_RecycleView)
        recycleView.layoutManager = LinearLayoutManager(this) // проверка ориентации
        recycleView.setHasFixedSize(true)
        recycleView.recycledViewPool.setMaxRecycledViews(0, 6)

        val adapter = NoteAdapter()
        adapter.notesList = repository.getAllNotes()!!
        adapter.listener = this
        recycleView.adapter = adapter
    }

    override fun onNoteClick(id: Long) {
        val note = repository!!.getNoteById(id)
        val intent = Intent(this, ShowNoteActivity::class.java)
        intent.putExtra(NOTE_TEXT, note?.Text)
        intent.putExtra(NOTE_IMAGE, note?.DrawableRes)
        startActivity(intent)
    }

    private fun buildRepository() {
        DaggerRepositoryComponent.builder()
            .appModule(AppModule(applicationContext))
            .repositoryModule(RepositoryModule())
            .build()
            .inject(this)
    }

}



