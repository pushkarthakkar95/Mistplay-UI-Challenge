package com.techtest.mistplaychallenge.model

import com.google.gson.annotations.SerializedName

//Simple data class for OOP and data handling
data class VerticalModel(@SerializedName("list_title") var gameCategory: String, @SerializedName("games") var listOfGames: MutableList<HorizontalModel>)