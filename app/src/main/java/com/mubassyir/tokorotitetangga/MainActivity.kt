package com.mubassyir.tokorotitetangga

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mubassyir.tokorotitetangga.adapter.BreadAdapter
import com.mubassyir.tokorotitetangga.data.BreadData
import com.mubassyir.tokorotitetangga.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val breadData = BreadData.breadData()

        val breadAdapter = BreadAdapter()
        breadAdapter.setData(breadData)

       with(binding.rvBread){
           layoutManager = LinearLayoutManager(context)
           adapter = breadAdapter
       }


    }
}