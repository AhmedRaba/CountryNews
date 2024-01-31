package com.example.countrynews

import android.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.countrynews.databinding.ActivityMainBinding
import com.example.countrynews.viewmodel.SharedViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedViewModel: SharedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        countryList()


        binding.btnNavigate.setOnClickListener {
            navigateToSecondActivity()
        }


    }


    private fun navigateToSecondActivity() {

        val intent = Intent(this, SecondActivity::class.java)


        intent.putExtra("country_name", selectCountry())
        startActivity(intent)
    }


    private fun selectCountry(): String {


        val countrySelected: String = when (binding.etCountryName.text.toString()) {
            "United States" -> "us"
            "China" -> "cn"
            "India" -> "in"
            "United Kingdom" -> "gb"
            "France" -> "fr"
            "Germany" -> "de"
            "Italy" -> "it"
            "Brazil" -> "br"
            "Canada" -> "ca"
            "Australia" -> "au"
            "Japan" -> "jp"
            "Russia" -> "ru"
            "South Korea" -> "kr"
            "Spain" -> "es"
            "Mexico" -> "mx"
            "Egypt" -> "eg"
            "Turkey" -> "tr"
            "Indonesia" -> "id"
            "Saudi Arabia" -> "sa"
            "South Africa" -> "za"
            else -> "eg" // Default case, you might want to change this
        }
        return countrySelected
    }


    private fun countryList() {
        val famousCountries = listOf(
            "United States",
            "China",
            "India",
            "United Kingdom",
            "France",
            "Germany",
            "Italy",
            "Brazil",
            "Canada",
            "Australia",
            "Japan",
            "Russia",
            "South Korea",
            "Spain",
            "Mexico",
            "Egypt",
            "Turkey",
            "Indonesia",
            "Saudi Arabia",
            "South Africa"
        ).sorted()



        val countryAdapter =
            ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, famousCountries)

        binding.etCountryName.setAdapter(countryAdapter)

    }


}