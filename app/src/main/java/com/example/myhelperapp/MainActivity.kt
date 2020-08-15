package com.example.myhelperapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myhelperapp.camera.CameraActivity
import com.example.myhelperapp.coroutines.CoroutineDemo
import com.example.myhelperapp.customLayouts.CustomLayoutActivity
import com.example.myhelperapp.customLayouts.customtable.CustomTableActivity
import com.example.myhelperapp.customnavdrawer.CustomNavDrawer
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

        main_nav_drawer_recycler_view.setOnClickListener {
            val intent = Intent(this, CustomNavDrawer::class.java)
            startActivity(intent)
        }

        main_kotlin_coroutine.setOnClickListener {
            val intent = Intent(this, CoroutineDemo::class.java)
            startActivity(intent)
        }

        main_custom_layout.setOnClickListener {
            val intent = Intent(this, CustomLayoutActivity::class.java)
            startActivity(intent)
        }

        main_table_layout.setOnClickListener {
            val intent = Intent(this, CustomTableActivity::class.java)
            startActivity(intent)
        }

        main_camera.setOnClickListener {
            startActivity(Intent(this, CameraActivity::class.java))
        }

        main_web_view.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }
    }
}