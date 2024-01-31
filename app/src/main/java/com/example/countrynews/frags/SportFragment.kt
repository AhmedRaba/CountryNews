package com.example.countrynews.frags

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.countrynews.ApiInterface
import com.example.countrynews.NewsAdapter
import com.example.countrynews.data.News
import com.example.countrynews.databinding.FragmentSportBinding
import com.example.countrynews.viewmodel.SharedViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SportFragment : Fragment() {
    private lateinit var binding: FragmentSportBinding
    private lateinit var sharedViewModel: SharedViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSportBinding.inflate(inflater)


        sharedViewModel=ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        sharedViewModel.getData().observe(viewLifecycleOwner, Observer {
            showSportNews(it)
        })



        return binding.root
    }

    private fun showSportNews(countryName: String) {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterface::class.java)

        retrofit.getModifiedNews(countryName, "sports")
            .enqueue(object : Callback<News> {
                override fun onResponse(call: Call<News>, response: Response<News>) {
                    val newsData = response.body()!!
                    val adapter = NewsAdapter(newsData)
                    binding.recycler.adapter = adapter
                }

                override fun onFailure(call: Call<News>, t: Throwable) {
                    Log.d("Hello", t.message.toString())
                }
            })
    }

}