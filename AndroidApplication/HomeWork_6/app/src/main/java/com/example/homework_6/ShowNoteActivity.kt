package com.example.homework_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ShowNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_note)
        findViewById<TextView>(R.id.fullText).text = intent.extras!!["TEXT"] as String
        findViewById<ImageView>(R.id.imageView2).setImageResource(intent.extras!!["IMAGE"] as Int)
    }
}
