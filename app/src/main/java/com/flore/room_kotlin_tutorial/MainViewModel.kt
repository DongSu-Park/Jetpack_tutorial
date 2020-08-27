package com.flore.room_kotlin_tutorial

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room

class MainViewModel(application: Application) : AndroidViewModel(application) {
    // Room DB 생성
    private val db = Room.databaseBuilder(
            application,
    AppDatabase::class.java, "database-name"
    ).build()

    // LiveData 적용
    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    // Coroutine 적용
    suspend fun insert(todo : Todo){
        db.todoDao().insert(todo)
    }
}