package com.example.notesapp.viewNodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.example.notesapp.model.Note
import com.example.notesapp.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteActivityViewModel(private val repository: NoteRepository):ViewModel() {
    fun saveNote(newNote:Note)= viewModelScope.launch (Dispatchers.IO){
        repository.addNote(newNote)

    }
    fun updateNote(existingNote:Note)= viewModelScope.launch (Dispatchers.IO){
        repository.updateNode(existingNote)

    }
    fun deleteNote(deleteNote:Note)= viewModelScope.launch (Dispatchers.IO){
        repository.deleteNote(deleteNote)

    }
    fun searchNote(query: String): LiveData<List<Note>> {
        return repository.searchNote(query)
    }
    fun getAllNote(): LiveData<List<Note>> =repository.getNote()

}