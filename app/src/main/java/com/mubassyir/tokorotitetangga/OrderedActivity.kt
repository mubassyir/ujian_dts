package com.mubassyir.tokorotitetangga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.mubassyir.tokorotitetangga.adapter.OrderedAdapter
import com.mubassyir.tokorotitetangga.database.DatabaseBuilder
import com.mubassyir.tokorotitetangga.database.DatabaseHelperImpl
import com.mubassyir.tokorotitetangga.databinding.ActivityOrderedBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class OrderedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderedBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderedBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val orderedAdapter = OrderedAdapter()

        with(binding.rvOrdered) {
            layoutManager = LinearLayoutManager(context)
            adapter = orderedAdapter
        }
        val dbHelper = DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
        runBlocking {
            withContext(Dispatchers.IO){
                Log.d("db",dbHelper.getAllOrder().toString())
                orderedAdapter.setData(dbHelper.getAllOrder())
            }
        }

    }


}