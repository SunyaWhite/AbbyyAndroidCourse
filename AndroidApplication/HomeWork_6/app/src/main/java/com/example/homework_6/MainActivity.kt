package com.example.homework_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<CardView>(R.id.note).setOnClickListener {v: View? -> onClick(v) }
    }

    private fun onClick(view : View?){
        val intent : Intent
        when(view?.id)
        {
            R.id.note -> intent = Intent(this, ShowNoteActivity::class.java)
            else -> throw Exception("No view was found")
        }
        //error("Button clicked")
        startActivity(intent)
    }
}
