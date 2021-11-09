package com.example.ambarrukmo

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
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

        SetStatusBar()
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

    private fun SetStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun setWindowFlag(bits: Int, on: Boolean) {
        val win = window
        val winParams = win.attributes
        if (on) {
            winParams.flags = winParams.flags or bits
        } else {
            winParams.flags = winParams.flags and bits.inv()
        }
        win.attributes = winParams
    }

}