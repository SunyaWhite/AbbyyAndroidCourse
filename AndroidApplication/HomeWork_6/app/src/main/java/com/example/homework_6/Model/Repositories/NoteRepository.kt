package com.example.homework_6.Model

import android.content.Context
import android.util.Log
import com.example.homework_6.R
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.exceptions.RealmException
import io.realm.kotlin.deleteFromRealm
import io.realm.kotlin.where
import java.lang.Exception
import java.util.*
import kotlin.random.Random

internal class NoteRepository(val context: Context) : INoteRepository {

    private val config : RealmConfiguration
    private val realm : Realm

    init {
        Realm.init(context)
        config = RealmConfig.provideDefaultConfiguration()
        realm = Realm.getInstance(config)
        generateSampleData()
    }

    override fun getAllNotes(): List<Note>? =
        realm.where<Note>().findAll()

    override fun getNoteById(id : Long): Note? =
        realm.where<Note>().equalTo("Id", id).findFirst()

    override fun addNewNote(note : Note): Boolean {
        try {
            realm.executeTransaction { realm ->
                val realmResult = realm.copyToRealm<Note>(note)
                if(realmResult == null)
                    throw RealmException("Unable to add note to the database. Note ${note.toString()}")
            }
        }
        catch(ex : Exception) {
            Log.e("REALM EXCEPTION", ex.message)
            return false
        }
        finally {
            return true
        }
    }

    override fun deleteNote(id : Long): Boolean {
        try {
            realm.executeTransaction { realm ->
                val note = realm.where<Note>().equalTo("Id", id).findFirst()
                note?.deleteFromRealm()
            }
        }
        catch (ex : Exception){
            Log.e("REALM EXCEPTION", ex.message)
            return false
        }
        finally {
            return true
        }
    }


    private fun generateSampleData() {

        if(realm.where<Note>().count() != 0L)
            return

        context.assets.open("notes.txt")
            .bufferedReader()
            .readText().split("\n\n")
            .fold(0L) { acc, s ->
                if(s == "")
                    acc
                this.addNewNote(Note(acc, generateRandomDate(), s, selectDrawable( acc % 4 + 1)))
                acc + 1
            }
    }

    private fun generateRandomDate() : Date=
        Date(Random.nextInt(2000, 2020), Random.nextInt(1, 13), Random.nextInt(1, 30))

    private fun selectDrawable(id : Long) =
        when(id)
        {
            1L -> R.drawable.cat1
            2L -> R.drawable.cat2
            3L -> R.drawable.cat3
            4L -> R.drawable.cat4
            else -> R.drawable.ic_launcher_foreground
        }

}