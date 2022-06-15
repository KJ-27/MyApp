package com.example.lugares.repository

import androidx.lifecycle.LiveData
import com.example.lugares.data.LibroDao
import com.example.lugares.model.Libro

class LibroRepository(private val libroDao: LibroDao) {
    val getAllData: LiveData<List<Libro>> = libroDao.getAllData()

    suspend fun addLibro(libro: Libro){
        libroDao.addLibro(libro)
    }

    suspend fun updateLibro(libro: Libro){
        libroDao.updateLibro(libro)
    }

    suspend fun deleteLibro(libro: Libro){
        libroDao.deleteLibro(libro)
    }
}