package com.example.examultimedia2eva.data

import androidx.room.Database
import androidx.room.RoomDatabase
//Base de datos
@Database( entities = [Person::class],
    version = 1)
abstract class PeopleDB : RoomDatabase() {
    abstract  fun personDao():PersonDao
}