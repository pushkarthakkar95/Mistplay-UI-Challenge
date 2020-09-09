package com.techtest.mistplaychallenge.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.techtest.mistplaychallenge.R
import com.techtest.mistplaychallenge.model.HorizontalModel
import kotlinx.android.synthetic.main.inner_element_layout.view.*

/**
 * The class acts as the adapter for lower level (horizontal) recycler view **/
class HorizontalRecyclerViewAdapter(val context: Context, val games: MutableList<HorizontalModel>)
    : RecyclerView.Adapter<HorizontalRecyclerViewAdapter.CustomHorizontalViewHolder>() {

    //view holder pattern to optimize recycle views
    class CustomHorizontalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val gameImage: ImageView = itemView.thumbnailIV
        val gameTitle: TextView = itemView.gameTitleTV
    }

    //inflates each view element
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomHorizontalViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.inner_element_layout,parent,false)
        return CustomHorizontalViewHolder(
            view
        )
    }

    //returns size or count of list elements
    override fun getItemCount(): Int {
        return games.size
    }

    //Binds data to view holder elements
    override fun onBindViewHolder(holder: CustomHorizontalViewHolder, position: Int) {
        val model = games[position] //fetch each game in the category at position in list
        holder.gameTitle.text = model.gameTitle //set game title

        //Following snippet uses glide to convert url to image in image view
        Glide.with(context.applicationContext)
            .load(model.imageUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .dontAnimate()
            .into(holder.gameImage)
    }
}