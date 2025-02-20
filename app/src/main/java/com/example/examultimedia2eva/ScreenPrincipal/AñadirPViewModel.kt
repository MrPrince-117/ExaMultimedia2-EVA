package com.example.examultimedia2eva.ScreenPrincipal

import android.app.Application

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.examultimedia2eva.data.PeopleDB
import com.example.examultimedia2eva.data.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AñadirPViewModel(application: Application) : AndroidViewModel(application) {

    //Creacion de la base de datos
    private val db = Room.databaseBuilder(
        application, PeopleDB::class.java, "person_db"
    ).build()

    //Objeto DAO para trabajar con la base de datos
    private val personDao = db.personDao()

    //Variables de la app
    val peopleList = mutableStateListOf<Person>()

    var name by mutableStateOf("")
    var age by mutableStateOf("")
    var code by mutableStateOf("")
    var selectedPerson: Person? by mutableStateOf(null)

    //Carga las personas en la base de datos
    init {
        loadPeople()
    }

    //Metodo de actualizacion de la lista
    private fun loadPeople() {
        viewModelScope.launch {
            val people = withContext(Dispatchers.IO) { personDao.getAll() }
            peopleList.clear()
            peopleList.addAll(people)
        }
    }

    //Metodo para añadir las personas
    fun addPerson() {
        if (name.isNotEmpty() && age.isNotEmpty() && code.isNotEmpty()) {
            viewModelScope.launch {
                val newPerson = Person(id = 0, name = name, age = age.toInt(), code = code.toInt())
                withContext(Dispatchers.IO) {
                    personDao.insert(listOf(newPerson))
                }
                loadPeople()
                clearFields()
            }
        }
    }

    //Metodo que resetea las variables para volver a usarlas
    private fun clearFields() {
        name = ""
        age = ""
        code = ""
    }

}

