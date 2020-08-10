package com.example.myhelperapp.customnavdrawer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myhelperapp.R
import kotlinx.android.synthetic.main.nav_drawer_rv_item.view.*

class NavDrawerAdapter(private val context: Context,
                       private val menuList: List<MenuItem>) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.nav_drawer_rv_item, null)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.nav_drawer_rv_item_name.text = menuList[position].name
        holder.view.nav_drawer_rv_item_icon.setImageResource(menuList[position].icon)
    }
}

class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view){

}