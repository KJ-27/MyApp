package com.example.lugares.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.lugares.data.LibroDataBase
import com.example.lugares.model.Libro
import com.example.lugares.repository.LibroRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LibroViewModel(application: Application) : AndroidViewModel(application) {
    val getAllData: LiveData<List<Libro>>

    private val repository: LibroRepository

    init {
        val libroDao = LibroDataBase.getDatabase(application).libroDao()
        repository = LibroRepository(libroDao)
        getAllData = repository.getAllData
    }

    fun addLibro (libro: Libro) {
        viewModelScope.launch(Dispatchers.IO) { repository.addLibro(libro) }
    }

    fun updateLibro (libro: Libro){
        viewModelScope.launch(Dispatchers.IO) { repository.updateLibro(libro) }
    }

    fun deleteLibro (libro: Libro){
        viewModelScope.launch(Dispatchers.IO) { repository.deleteLibro(libro) }
    }
}