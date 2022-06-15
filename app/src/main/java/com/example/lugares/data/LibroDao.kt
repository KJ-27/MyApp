package com.example.lugares.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.lugares.model.Libro

@Dao
interface LibroDao {
    @Query ("SELECT * FROM LIBRO")
    fun getAllData() : LiveData<List<Libro>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLibro(libro : Libro)

    @Update(onConflict =  OnConflictStrategy.IGNORE)
    suspend fun updateLibro(libro: Libro)

    @Delete
    suspend fun deleteLibro(libro: Libro)
}