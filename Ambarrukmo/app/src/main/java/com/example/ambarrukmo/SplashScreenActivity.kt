package com.example.ambarrukmo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ambarrukmo.activity.MainActivity
import com.example.ambarrukmo.activity.WalktroughActivity
import com.example.ambarrukmo.api.DataManager
import com.example.ambarrukmo.databinding.ActivitySplashScreenBinding
import kotlinx.coroutines.delay

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onSplash()
    }

    private fun onSplash() {
        super.onResume()
        if (DataManager.getInstance().isLogin == true){
            delayHome()
        } else {
            delayToIntro()
        }
    }

    private fun delayHome() {
        val thread = Thread{
            try {
                Thread.sleep(2000)
            } catch (ex: InterruptedException){
                ex.printStackTrace()
            } finally {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
        thread.start()
    }


    private fun delayToIntro() {
        val thread = Thread{
            try {
                Thread.sleep(2000)
            } catch (ex: InterruptedException){
                ex.printStackTrace()
            } finally {
                startActivity(Intent(this, WalktroughActivity::class.java))
                finish()
            }
        }
        thread.start()
    }

}