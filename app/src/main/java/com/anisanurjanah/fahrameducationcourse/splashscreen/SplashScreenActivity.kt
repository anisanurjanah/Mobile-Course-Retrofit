package com.anisanurjanah.fahrameducationcourse.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anisanurjanah.fahrameducationcourse.MainActivity
import com.anisanurjanah.fahrameducationcourse.R
import com.anisanurjanah.fahrameducationcourse.databinding.ActivitySplashScreenBinding
import com.bumptech.glide.Glide

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    private var delay: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupImage()
        window.decorView.postDelayed({
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            finish()
        }, delay)
    }

    private fun setupImage() {
        val image = "https://fahram.dev/img/logo.webp"
        Glide.with(this@SplashScreenActivity)
            .load(image)
            .placeholder(R.drawable.ic_image)
            .into(binding.imageLogo)
    }
}