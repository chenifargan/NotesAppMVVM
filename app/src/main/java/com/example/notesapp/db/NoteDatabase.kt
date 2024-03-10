package com.example.notesapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapp.model.Note

@Database(
    entities = [Note::class],
    version= 1,
    exportSchema = false

)
abstract class NoteDatabase :RoomDatabase(){

    abstract fun getNoteDAO():DAO

    companion object{
        @Volatile
        private var instant:NoteDatabase?=null
        private val LOCK =Any()
        operator  fun invoke(context: Context)= instant?: synchronized(LOCK){
            instant?: createDataBase(context).also {
                instant=it
            }
        }
        private fun createDataBase(context:Context)= Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            "note_database"
        ).build()
    }













}