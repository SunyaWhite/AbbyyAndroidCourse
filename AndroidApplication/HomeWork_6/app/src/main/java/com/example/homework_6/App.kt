package com.example.homework_6

import android.app.Application
import com.example.homework_6.Model.NoteRepository

class App : Application() {

    public override fun onCreate() {
        super.onCreate()
        NoteRepository.Initialize()
    }

}