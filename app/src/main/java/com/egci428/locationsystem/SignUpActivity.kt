package com.egci428.locationsystem

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.text.DecimalFormat
import java.util.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        addBtn.setOnClickListener {
            DataProvider.addData(User(userSignupEdit.text.toString(),passSignUpEdit.text.toString(),LatEdit.text.toString().toDouble(),LongEdit.text.toString().toDouble()))
        }
        randomBtn.setOnClickListener {
            val latMax = 85
            val latMin = -85
            val longMax = 179.999989
            val longMin = -179.999989

            val randLat = DecimalFormat("#0.000000").format(latMin + ((latMax - latMin)*Random().nextDouble()))
            val randLong = DecimalFormat("#0.000000").format(longMin + ((longMax - longMin)*Random().nextDouble()))
            LatEdit.setText(randLat.toString())
            LongEdit.setText(randLong.toString())
            finish()

        }
    }
}
