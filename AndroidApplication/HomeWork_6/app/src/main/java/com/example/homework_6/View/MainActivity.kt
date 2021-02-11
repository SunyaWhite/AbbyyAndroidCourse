package com.example.homework_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonMain).setOnClickListener { v: View? -> onClick(v) }
    }

    private fun onClick(view : View?){
        val intent : Intent
        when(view?.id)
        {
            //R.id.note -> intent = Intent(this, ShowNoteActivity::class.java)
            R.id.buttonMain -> intent = Intent(this, NoteRecycleActivity :: class.java)
            else -> throw Exception("No view was found")
        }
        startActivity(intent)
    }
}
