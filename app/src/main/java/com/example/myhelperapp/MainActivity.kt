package com.example.myhelperapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myhelperapp.navdrawerwithsubmenu.NavDrawerWithSubMenuActivity
import com.example.myhelperapp.recyclerview.RecyclerViewActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_recycler_view_btn.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        main_nav_drawer_with_submenu.setOnClickListener {
            val intent = Intent(this, NavDrawerWithSubMenuActivity::class.java)
            startActivity(intent)
        }
    }
}