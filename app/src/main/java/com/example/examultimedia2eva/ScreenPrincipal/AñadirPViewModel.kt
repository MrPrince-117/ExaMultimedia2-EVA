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
import kotlinx.coroutines.GlobalScope
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

    var name by mutableStateOf("Borja")
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
    private var count = 0
    fun addPerson() {
        GlobalScope.launch {
            (0..9).forEach { _ ->
                val newReg = Person(
                    name = "Sr/a ${name}_${count++}",
                    age = (18..100).random(),
                    code = (1000..10000).random()
                )
                // Código para insertar en la BD
                personDao.insert(newReg) // Guarda en la BD

                withContext(Dispatchers.Main) {
                    peopleList.add(newReg) // Actualiza la UI
                }
            }
        }
    }




}

