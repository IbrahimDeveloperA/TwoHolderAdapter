package com.example.twoholderadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.twoholderadapter.data.LandmarkModel
import com.example.twoholderadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val landmarks = LandmarkModel.getLandmarks()
        binding.landmarkRecyclerview.apply {
            adapter = LandmarkAdapter(landmarks)
        }
    }

}