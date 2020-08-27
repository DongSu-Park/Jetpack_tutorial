package com.flore.room_kotlin_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    // ViewModel ktx 사용
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // LiveData 사용 (ViewModel 포함)
        viewModel.getAll().observe(this, Observer { todos ->
            Log.d(TAG, "LiveData UI Update")
            tv_result.text = todos.toString()
        })

        // Coroutine 사용 (비동기 처리, ViewModel 포함)
        btn_add.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.insert(Todo(et_todo.text.toString()))
            }
        }
    }
}