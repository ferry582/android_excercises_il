package com.myapp.androidexcercisesil.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myapp.androidexcercisesil.R
import com.myapp.androidexcercisesil.models.Tour
import com.myapp.androidexcercisesil.adapters.TourListAdapter

class rvActivity : AppCompatActivity() {

    private lateinit var rvTours: RecyclerView
    private val list = ArrayList<Tour>()
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyleview)

        // Action Bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "RecyclerView"

        list.addAll(listTours)

        rvTours = findViewById(R.id.rvTours)
        rvTours.setHasFixedSize(true)
        rvTours.layoutManager = LinearLayoutManager(this)
        rvTours.adapter = TourListAdapter(this, list){
            val intent = Intent (this, DetailTourActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

    }

    private val listTours: ArrayList<Tour>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

            val lists = ArrayList<Tour>()
            for (i in dataName.indices) {
                val tour = Tour(
                    dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1)
                )
                lists.add(tour)
            }
            return lists
        }

}