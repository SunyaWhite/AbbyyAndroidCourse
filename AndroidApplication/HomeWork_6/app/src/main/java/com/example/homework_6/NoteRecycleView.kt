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

public interface Listener{
    fun onNoteClick(id: Long)
}

class NoteRecycleView : AppCompatActivity(), Listener {

    private var repository : NoteRepository? = null

    override fun onNoteClick(id: Long) {
        val note = repository!!.getNoteById(id)
        val intent = Intent(this, ShowNoteActivity::class.java)
        intent.putExtra("TEXT", note.text)
        intent.putExtra("IMAGE", note.drawableRes)
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

class NoteAdapter : RecyclerView.Adapter<NoteViewHolder>() {

    var notesList : List<Note> = listOf()

    var listener : Listener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(
            R.layout.note_view_item,
            parent,
            false
        )
        return NoteViewHolder(view, listener!!)
    }

    override fun getItemCount(): Int = notesList.count()

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) =
        holder.bind(notesList[position])

}

class NoteViewHolder(itemView : View, val listener : Listener) : RecyclerView.ViewHolder(itemView)
{

    fun bind (note : Note){
        itemView.findViewById<TextView>(R.id.noteTextView).text = note.text
        itemView.findViewById<TextView>(R.id.noteLabelView).text = note.date.toString()
        itemView.findViewById<ImageView>(R.id.noteImageView).setImageResource(note.drawableRes)
        itemView.setOnClickListener { v -> listener.onNoteClick(note.id) }
    }
}



