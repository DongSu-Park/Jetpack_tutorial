package com.flore.room_kotlin_tutorial

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao{
    @Query("SELECT * FROM Todo")
    fun getAll() : LiveData<List<Todo>>

    @Insert
    fun insert(todo : Todo)

    @Update
    fun update(todo : Todo)

    @Delete
    fun delete(todo : Todo)

}