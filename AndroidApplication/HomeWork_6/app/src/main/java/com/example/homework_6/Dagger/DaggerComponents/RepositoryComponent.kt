package com.example.homework_6.Dagger

import com.example.homework_6.MainActivity
import com.example.homework_6.NoteRecycleActivity
import dagger.Component

@Component(modules = [AppModule::class, RepositoryModule::class])
interface RepositoryComponent {

    fun inject(activity : MainActivity)

    fun inject(activity: NoteRecycleActivity)
}