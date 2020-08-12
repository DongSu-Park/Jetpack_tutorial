package com.flore.room_kotlin_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application!!)).get(MainViewModel::class.java)

        viewModel.getAll().observe(this, Observer {todos ->
            Log.d(TAG,"LiveData UI Update")
            tv_result.text = todos.toString()
        })

        btn_add.setOnClickListener {
            viewModel.insert(Todo(et_todo.text.toString()))
        }
    }
}