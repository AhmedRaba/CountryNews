package com.example.countrynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.countrynews.databinding.ActivitySecondBinding
import com.example.countrynews.viewmodel.SharedViewModel
import com.google.android.material.tabs.TabLayoutMediator

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var sharedViewModel: SharedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val countryName = intent.getStringExtra("country_name")


        sharedViewModel = ViewModelProvider(this)[SharedViewModel::class.java]
        sharedViewModel.setData(countryName.toString())


        val pagerAdapter = ViewPagerAdapter(this)

        binding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "General"
                1 -> tab.text = "Business"
                2 -> tab.text = "Sport"
                3 -> tab.text = "Technology"
            }
        }.attach()


    }





}