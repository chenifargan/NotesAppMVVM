package com.example.notesapp.repository

import com.example.notesapp.db.NoteDatabase
import com.example.notesapp.model.Note

class NoteRepository(private val db:NoteDatabase) {

    fun getNote()=db.getNoteDAO().getAllNote()

    fun searchNote(query:String)=db.getNoteDAO().searchNote(query)

    suspend fun addNote(note:Note)=db.getNoteDAO().addNote(note)

    suspend fun updateNode(note:Note)=db.getNoteDAO().updateNote(note)

    suspend  fun deleteNote(note: Note)=db.getNoteDAO().deleteNote(note)

}