package com.example.instituteofmining.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.instituteofmining.R
import com.example.instituteofmining.main.MainActivity

class SplashActivity : AppCompatActivity(){
    private val SPLASH_TIME: Long = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initSplashScreen()
    }

    private fun initSplashScreen() {
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_TIME)

    }
}