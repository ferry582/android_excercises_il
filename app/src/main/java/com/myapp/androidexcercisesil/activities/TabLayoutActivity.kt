package com.myapp.androidexcercisesil.activities

import android.content.res.Resources
import android.content.res.Resources.NotFoundException
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.myapp.androidexcercisesil.R
import com.myapp.androidexcercisesil.adapters.PagerAdapter

class TabLayoutActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_layout)

        // Action Bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Tab Layout"

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        viewPager.adapter = PagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager){ tab, index ->
            tab.text = when (index) {
                0 -> { "First"}
                1 -> { "Second"}
                2 -> { "Third"}
                else -> {throw Resources.NotFoundException("Position Not Found")}
            }
        }.attach()
    }
}