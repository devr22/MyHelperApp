package com.example.myhelperapp.navdrawerwithsubmenu

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.myhelperapp.R

class ExpandableListViewAdapter internal constructor(
    private val context: Context,
    private val menuList: List<String>,
    private val submenuList: Map<String, List<String>>
): BaseExpandableListAdapter() {

    override fun getGroup(p0: Int): Any {
        return menuList[p0]
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        var convertView = p2
        val menuTitle = getGroup(p0) as String

        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.nav_menu_item, null)
        }
        val menuTv = convertView!!.findViewById<TextView>(R.id.nav_menu_tv)
        menuTv.text = menuTitle

        return convertView
    }

    override fun getChildrenCount(p0: Int): Int {
        return this.submenuList[this.menuList[p0]]!!.size
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return this.submenuList[this.menuList[p0]]!![p1]
    }

    override fun getGroupId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        var convertView = p3
        val submenuTitle = getChild(p0, p1) as String

        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.nav_sub_menu_item, null)
        }
        val submenuTv = convertView!!.findViewById<TextView>(R.id.nav_submenu_tv)
        submenuTv.text = submenuTitle

        return convertView
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun getGroupCount(): Int {
        return menuList.size
    }
}