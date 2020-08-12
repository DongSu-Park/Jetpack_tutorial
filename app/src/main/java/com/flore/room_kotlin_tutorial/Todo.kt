package com.flore.room_kotlin_tutorial

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Todo(
    var title : String
){
    @PrimaryKey(autoGenerate = true) var id : Int = 0
}

