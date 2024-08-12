package com.anisanurjanah.fahrameducationcourse.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anisanurjanah.fahrameducationcourse.favorite.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}