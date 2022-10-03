package com.codehub.metroapp.mvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.codehub.metroapp.databinding.ActivityMvvmBinding

class MvvmActivity : AppCompatActivity() {

    private val viewModel: MvvmViewModel by viewModels()
    private val AviewModel: AndroidMvvmViewModel by viewModels()

    private lateinit var binding: ActivityMvvmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        viewModel = ViewModelProvider(this)[MvvmViewModel::class.java]
//        AviewModel = ViewModelProvider(this)[AndroidMvvmViewModel::class.java]
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        viewModel.observeData(this, Observer {
            binding.title.text = it
        })
    }

    override fun onPostResume() {
        super.onPostResume()

        viewModel.retrieveApiData(this)
    }

}