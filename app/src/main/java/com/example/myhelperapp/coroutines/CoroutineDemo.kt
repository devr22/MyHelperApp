package com.example.myhelperapp.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myhelperapp.R
import kotlinx.android.synthetic.main.activity_coroutine_demo.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoroutineDemo : AppCompatActivity() {

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_demo)

        coroutine_count_btn.setOnClickListener {
            coroutine_count_tv.text = count++.toString()
        }

        coroutine_download_btn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                downloadUserData()
            }
        }
    }

    private fun downloadUserData() {
        for (i in 1..200000) {
            Log.d("MyTag", "Download user $i in ${Thread.currentThread().name}")
        }
    }

}