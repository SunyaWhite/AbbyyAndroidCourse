package com.example.homework_6.Dagger

import com.example.homework_6.NoteRecycleActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RepositoryModule::class])
interface RepositoryComponent {

    fun inject(activity: NoteRecycleActivity)
}