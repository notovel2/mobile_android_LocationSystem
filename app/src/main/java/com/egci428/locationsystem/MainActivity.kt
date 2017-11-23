package com.egci428.locationsystem

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        signInBtn.setOnClickListener {
            if(SignIn(userEditText.text.toString(),passEditText.text.toString())) {
                val intent = Intent(this, MainPageActivity::class.java)
                startActivity(intent)
            }
        }
        signUpBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun SignIn(username:String,password:String):Boolean{
        val userSet = DataProvider.getHashData()
        if(userSet.contains(username)){
            if(userSet.get(username)!!.password.equals(password)){
                return true
            }
        }
        return false
    }
}
