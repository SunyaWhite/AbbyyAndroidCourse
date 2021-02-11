package com.example.homework_6.Dagger

import android.content.Context
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

@Module
class AppModule(private val context : Context) {

    @Provides
    @NotNull
    @Singleton
    fun provideContext() : Context = context
}