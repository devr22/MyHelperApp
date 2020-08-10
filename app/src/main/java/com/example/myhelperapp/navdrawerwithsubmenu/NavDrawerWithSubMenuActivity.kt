package com.example.myhelperapp.navdrawerwithsubmenu

import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.myhelperapp.R
import kotlinx.android.synthetic.main.activity_nav_drawer_with_sub_menu.*
import kotlinx.android.synthetic.main.content_drawer_activity.*

class NavDrawerWithSubMenuActivity : AppCompatActivity() {

    private lateinit var listViewAdapter: ExpandableListViewAdapter
    private lateinit var menuList: List<String>
    private lateinit var submenuList: HashMap<String, List<String>>

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_drawer_with_sub_menu)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)

        val toggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this, drawerLayout,
            toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        ) {

        }
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        initialiseMenuItem()

        listViewAdapter = ExpandableListViewAdapter(this, menuList, submenuList)
        expandable_list_view.setAdapter(listViewAdapter)

        expandable_list_view!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            val selectedGroup = (menuList as ArrayList<String>)[groupPosition]
            val clickedItem: String  = submenuList[(menuList as ArrayList<String>)[groupPosition]]!!.get(childPosition)

            val title = "$selectedGroup -> $clickedItem"

            Toast.makeText(this, "Clicked: $title", Toast.LENGTH_SHORT).show()

            Handler().postDelayed({
                drawerLayout.closeDrawer(GravityCompat.START)
            }, 200)
        }
    }

    private fun initialiseMenuItem() {
        menuList = ArrayList()
        submenuList = HashMap()

        (menuList as ArrayList<String>).add("Section 1")
        (menuList as ArrayList<String>).add("Section 2")
        (menuList as ArrayList<String>).add("Section 3")
        (menuList as ArrayList<String>).add("Section 4")

        val topic1: MutableList<String> = ArrayList()
        topic1.add("Topic 1")
        topic1.add("Topic 2")
        topic1.add("Topic 3")
        topic1.add("Topic 4")

        val topic2: MutableList<String> = ArrayList()
        topic2.add("Topic 1")
        topic2.add("Topic 2")
        topic2.add("Topic 3")
        topic2.add("Topic 4")

        val topic3: MutableList<String> = ArrayList()
        topic3.add("Topic 1")
        topic3.add("Topic 2")
        topic3.add("Topic 3")

        val topic4: MutableList<String> = ArrayList()
        topic4.add("Topic 1")
        topic4.add("Topic 2")

        submenuList[menuList[0]] = topic1
        submenuList[menuList[1]] = topic2
        submenuList[menuList[2]] = topic3
        submenuList[menuList[3]] = topic4
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
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