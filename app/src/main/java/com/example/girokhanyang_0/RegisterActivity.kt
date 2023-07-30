package com.example.girokhanyang_0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {

    private lateinit var mBtnRegist : Button
    private lateinit var mTxtLogin : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mBtnRegist = findViewById(R.id.btn_regist)
        mTxtLogin = findViewById(R.id.t_login)

        mBtnRegist.setOnClickListener {
            val intent = Intent(this, UserJoinActivity::class.java)
            startActivity(intent)
            finish()
        }

        mTxtLogin.setOnClickListener {
            val intent = Intent(this, UserLoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}