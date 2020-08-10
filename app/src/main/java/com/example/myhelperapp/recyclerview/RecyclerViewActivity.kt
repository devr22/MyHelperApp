package com.example.myhelperapp.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhelperapp.R
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    private val contactList: List<Contact> = listOf(Contact("Rahul", "6265105303"),
        Contact("Dev", "9934568643"),
        Contact("John", "9874562580"),
        Contact("Thomas", "6547891230"),
        Contact("Dev", "9934568643"),
        Contact("John", "9874562580"),
        Contact("Thomas", "6547891230"),
        Contact("Dev", "9934568643"),
        Contact("John", "9874562580"),
        Contact("Thomas", "6547891230")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = MyRecyclerViewAdapter(contactList)

    }
}