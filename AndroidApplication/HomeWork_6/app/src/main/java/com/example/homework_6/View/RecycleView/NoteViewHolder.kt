package com.example.homework_6

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_6.Model.Note
import com.example.homework_6.R

class NoteViewHolder(itemView : View, val listener : Listener) : RecyclerView.ViewHolder(itemView)
{

    fun bind (note : Note){
        itemView.findViewById<TextView>(R.id.noteTextView).text = note.Text
        itemView.findViewById<TextView>(R.id.noteLabelView).text = note.Date.toString()
        itemView.findViewById<ImageView>(R.id.noteImageView).setImageResource(note.DrawableRes)
        itemView.setOnClickListener { v -> listener.onNoteClick(note.Id) }
    }
}