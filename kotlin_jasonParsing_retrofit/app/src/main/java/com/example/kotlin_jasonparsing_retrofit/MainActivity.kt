package com.example.kotlin_jasonparsing_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_jasonparsing_retrofit.databinding.ActivityMainBinding
import com.example.kotlin_jasonparsing_retrofit.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        repository()
    }


    private fun repository() {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->

            if(response.isSuccessful) {
                Log.d("Response userId", response.body()?.userId.toString())
                Log.d("Response id", response.body()?.id.toString())
                Log.d("Response title", response.body()?.title!!)
                binding.textView.text = response.body()?.title!!
                Log.d("Response body", response.body()?.body!!)
            } else {
                Log.d("Response error", response.errorBody().toString())
                binding.textView.text = response.code().toString()
            }
        })
    }
}