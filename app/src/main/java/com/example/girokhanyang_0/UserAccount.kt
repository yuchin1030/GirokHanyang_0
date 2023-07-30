package com.example.girokhanyang_0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class UserAccount : AppCompatActivity() {

    private var idToken: String? = null
    private var emailId : String? = null
    private var password : String? = null
    private var nickname : String? = null

    fun setIdToken(idToken: String?) {
        this.idToken = idToken
    }

    fun getIdToken(): String? {
        return idToken
    }

    fun setEmailId(emailId: String?) {
        this.emailId = emailId
    }

    fun getEmailId(): String? {
        return emailId
    }

    fun setPassword(password: String?) {
        this.password = password
    }

    fun getPassword(): String? {
        return password
    }

    fun setNickname(nickname: String?) {
        this.nickname = nickname
    }

    fun getNickname(): String? {
        return nickname
    }

}
