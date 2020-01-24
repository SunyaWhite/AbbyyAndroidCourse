package com.example.homework_6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_6.Model.Note

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