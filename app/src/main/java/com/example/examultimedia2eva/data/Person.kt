package com.example.examultimedia2eva.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//Tabla de la base de datos
@Entity(tableName = "person_table")
data class Person(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    //Sentencia para asignar la clave primaria
    val name: String,
    val age: Int,
    val code: Int
)
