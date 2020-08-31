package com.flore.room_kotlin_tutorial

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    // Room DB 생성
    private val db = Room.databaseBuilder(
            application,
    AppDatabase::class.java, "database-name"
    ).build()

    var todos: LiveData<List<Todo>>

    var newTodo : String? = null

    init {
        todos = getAll()
    }

    // LiveData 적용
    fun getAll(): LiveData<List<Todo>> {
        return db.todoDao().getAll()
    }

    // Coroutine 적용
    fun insert(todo : String){
        viewModelScope.launch(Dispatchers.IO){
            db.todoDao().insert(Todo(todo))
        }
    }
}