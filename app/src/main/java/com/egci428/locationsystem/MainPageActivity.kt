package com.egci428.locationsystem

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main_page.*
import kotlinx.android.synthetic.main.user_item.view.*

class MainPageActivity : AppCompatActivity() {
    var userList = DataProvider.getdata()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        val userArrayAdapter = UserArrayAdapter(this,0,userList)
        list.setAdapter(userArrayAdapter)
        list.setOnItemClickListener { adapterView ,view ,position ,id ->
//            val course = data!!.get(position)
//            displayDetail(course,position)
            val intent = Intent(this,MapsActivity::class.java)
            intent.putExtra("Lat","${userList.get(position).lat.toString()}")
            intent.putExtra("Long","${userList.get(position).long.toString()}")
            startActivity(intent)
        }

    }

//    override fun onResume() {
//        super.onResume()
//        userList = DataProvider.getdata()
//        val userArrayAdapter = UserArrayAdapter(this,0,userList)
//        list.setAdapter(userArrayAdapter)
//    }
    private class UserArrayAdapter(var context: Context, resource: Int, var objects: ArrayList<User>) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view: View
            val user = objects[position]

            if(convertView == null){
                val layoutInflator = LayoutInflater.from(parent!!.context)
                view = layoutInflator.inflate(R.layout.user_item,parent,false)
                val viewHolder = ViewHolder(view.userText)
                view.tag = viewHolder
            }
            else {
                view = convertView
            }
            val viewHolder = view.tag as ViewHolder

            viewHolder.titleTextView.text = user.username
            return view
        }

        override fun getCount(): Int {
            return objects.size
        }

        override fun getItem(position: Int): Any {
            return objects[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        private class ViewHolder(val titleTextView: TextView){

        }

    }
}
