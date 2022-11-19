package com.myapp.androidexcercisesil.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.myapp.androidexcercisesil.R
import com.myapp.androidexcercisesil.models.Tour

class DetailTourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tour)

        // Action Bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Get Data
        val tour = intent.getParcelableExtra<Tour>(rvActivity.INTENT_PARCELABLE)

        // Set Data
        val tvName: TextView = findViewById(R.id.tvDetailName)
        val tvDescription: TextView = findViewById(R.id.tvDetailDescription)
        val ivPhoto: ImageView = findViewById(R.id.ivDetailPhoto)

        ivPhoto.setImageResource(tour?.photo!!)
        tvName.text = tour.name
        tvDescription.text = tour.description
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}