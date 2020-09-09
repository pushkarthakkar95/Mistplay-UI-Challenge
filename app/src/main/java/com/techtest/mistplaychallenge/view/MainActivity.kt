package com.techtest.mistplaychallenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.techtest.mistplaychallenge.R
import com.techtest.mistplaychallenge.view.adapters.VerticalRecyclerViewAdapter
import com.techtest.mistplaychallenge.databinding.ActivityMainBinding
import com.techtest.mistplaychallenge.model.VerticalModel
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val TAG = MainActivity::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //uses binding for optimization
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        val gson = Gson() //gson to convert json to data object
        val listOfAllGames = gson.fromJson(readSampleData(), Array<VerticalModel>::class.java).asList()
        val adapter =
            VerticalRecyclerViewAdapter(
                applicationContext,
                listOfAllGames
            ) //adapter for high level (vertical) recycler view
        binding.verticleRecyclerView.setHasFixedSize(true)
        //Setting layoutmanager as linear and vertical as required due to the UI design
        binding.verticleRecyclerView.layoutManager = LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
        //setting the above created adapter to recyclerview
        binding.verticleRecyclerView.adapter = adapter
    }

    //Method reads from txt file the json to populate the data in app.
    //Ideally needs to be REST API call
    fun readSampleData():String?{
        var jsonString: String
        try {
            jsonString = applicationContext.assets.open("sampledata").bufferedReader().use { it.readText() }
        }
        catch(e: IOException){
            Log.d(TAG,e.localizedMessage)
            return null
        }

        return jsonString
    }
}
