package com.durand.musicplayerjd

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.durand.musicplayerjd.databinding.ActivityFavoriteBinding
import com.durand.musicplayerjd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_MusicPlayerJD)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.shuffleButton.setOnClickListener {
            startActivity(Intent(this, PlayerActivity::class.java))
        }

        binding.favoriteButton.setOnClickListener {
            startActivity(Intent(this, FavoriteActivity::class.java))
        }

        binding.playlistButton.setOnClickListener {
            startActivity(Intent(this, PlayListActivity::class.java))
        }

    }
}