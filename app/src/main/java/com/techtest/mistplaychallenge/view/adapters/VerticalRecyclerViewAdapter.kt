package com.techtest.mistplaychallenge.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.techtest.mistplaychallenge.R
import com.techtest.mistplaychallenge.model.VerticalModel
import kotlinx.android.synthetic.main.element_layout.view.*

/**
 * The class acts as the adapter for high level (vertical) recycler view **/
class VerticalRecyclerViewAdapter(val context: Context, val games: List<VerticalModel>):
    RecyclerView.Adapter<VerticalRecyclerViewAdapter.CustomViewHolder>() {

    //view holder pattern to optimize recycle views
    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val categoryTitle: TextView = itemView.gameCategoryTV
        val horizontalRecyclerView: RecyclerView = itemView.horizontalRecyclerView
    }

    //inflates each view element
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.element_layout,parent,false)
        return CustomViewHolder(
            view
        )
    }

    //returns size or count of list elements
    override fun getItemCount(): Int {
        return games.size
    }

    //Binds data to view holder elements
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val verticalModel = games[position] //Fetch each category
        holder.categoryTitle.text = verticalModel.gameCategory //set category title

        val horizontalAdapter =
            HorizontalRecyclerViewAdapter(
                context,
                verticalModel.listOfGames
            ) //create adapter for horizontal recyclerview with list

        holder.horizontalRecyclerView.setHasFixedSize(true) //optimization
        holder.horizontalRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false) //set layout manager as horizontal

        holder.horizontalRecyclerView.adapter = horizontalAdapter //set adapter
    }
}