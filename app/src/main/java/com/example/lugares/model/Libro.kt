package com.example.lugares.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "libro")
data class Libro(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "escritor")
    val escritor: String?,
    @ColumnInfo(name = "paginas")
    val paginas: String,
    @ColumnInfo(name = "estatus")
    val estatus: String,
) : Parcelable