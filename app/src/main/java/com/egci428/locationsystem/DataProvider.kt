package com.egci428.locationsystem

import android.R.attr.targetName



/**
 * Created by 6272user on 11/23/2017 AD.
 */
object DataProvider {
    private val userList = ArrayList<User>()
    fun getdata(): ArrayList<User>{
        return userList
    }
    fun getHashData():HashMap<String,User>{
        var userSet = HashMap<String,User>()
        for (index in userList) {
            userSet.put(index.username,index)
        }
        return userSet
    }
    fun addData(data:User){
        userList.add(data)
    }
    init {
        userList.add(User("A","1111",100.3,50.2))
        userList.add(User("B","1111",100.3,50.2))
    }
}