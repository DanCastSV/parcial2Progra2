package com.example.parcialndos

import android.app.ActionBar
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.core.os.postDelayed
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //se agrega la animación
        val splashanimation = AnimationUtils.loadAnimation(this,R.anim.splash)
        img_vet.startAnimation(splashanimation)
        progressBar.startAnimation(splashanimation)

        //se configura para que la splash screen se agregue en pantalla completa
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.R){
            window.insetsController?.hide(WindowInsets.Type.statusBars())

        }
        else{
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        //Llama al intent y se configura el tiempo de espera
        @Suppress("DEPRECATION")
        Handler().postDelayed(
            {

                startActivity(
                     Intent(this@SplashActivity, MainActivity::class.java)

                )
                finish()

            },1500

        )
    }

}