package com.example.myhelperapp.customnavdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myhelperapp.R
import kotlinx.android.synthetic.main.activity_custom_nav_drawer.*
import kotlinx.android.synthetic.main.content_drawer_activity.*

class CustomNavDrawer : AppCompatActivity() {

    private val menuList = arrayListOf(
        MenuItem(R.drawable.ic_home, "Home"),
        MenuItem(R.drawable.ic_book, "Book"),
        MenuItem(R.drawable.ic_music, "Music"),
        MenuItem(R.drawable.ic_movie, "Movie"),
        MenuItem(R.drawable.ic_event, "Event")
    )

    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_nav_drawer)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.custom_drawer_layout)

        val toggle: ActionBarDrawerToggle =object :ActionBarDrawerToggle(this, drawer,
            toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
        }
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        content_textView.text = getString(R.string.custom_drawer)

        custom_nav_recycler_View.layoutManager = LinearLayoutManager(this)
        custom_nav_recycler_View.adapter = NavDrawerAdapter(this, menuList)

    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            // Checking for fragment count on back stack
            if (supportFragmentManager.backStackEntryCount > 0) {
                // Go to the previous fragment
                supportFragmentManager.popBackStack()
            } else {
                // Exit the app
                super.onBackPressed()
            }
        }
    }

}