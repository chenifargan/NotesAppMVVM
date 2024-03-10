package com.example.notesapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.db.NoteDatabase

import com.example.notesapp.repository.NoteRepository
import com.example.notesapp.viewNodel.NoteActivityViewModel
import com.example.notesapp.viewNodel.NoteActivityViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var noteActivityViewModel: NoteActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding=ActivityMainBinding.inflate(layoutInflater)
        try{
            setContentView(binding.root)
            val noteRepository = NoteRepository(NoteDatabase(this))
            val noteActivityViewModelFactory=NoteActivityViewModelFactory(noteRepository)
            noteActivityViewModel= ViewModelProvider(this,noteActivityViewModelFactory)[NoteActivityViewModel::class.java]

        }catch (e:Exception){
            Log.d("TAG","error")
        }
    }
}