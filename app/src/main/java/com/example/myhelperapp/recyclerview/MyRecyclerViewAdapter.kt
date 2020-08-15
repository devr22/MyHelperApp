package com.example.myhelperapp.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myhelperapp.R
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class MyRecyclerViewAdapter : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        /**
         * holder.view.candidate_name_tv.text = contactList[position].name
         * holder.view.candidate_phone_tv.text = contactList[position].phone
         *
         * in this case we don't need to write findViewById() in MyViewHolder class
         */
    }

}

class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
}

