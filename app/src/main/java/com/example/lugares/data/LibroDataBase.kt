package com.example.lugares.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lugares.model.Libro

@Database(entities = [Libro::class], version = 1, exportSchema = false)
abstract class LibroDataBase: RoomDatabase() {
    abstract fun libroDao() : LibroDao

    companion object {
        private var INSTANCE : LibroDataBase? = null

        fun getDatabase(context: android.content.Context) : LibroDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LibroDataBase::class.java,
                "libro_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}