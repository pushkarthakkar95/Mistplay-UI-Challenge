package com.techtest.mistplaychallenge.model

import com.google.gson.annotations.SerializedName

//Simple data class for OOP and data handling
data class HorizontalModel(@SerializedName("title") var gameTitle: String, @SerializedName("img")var imageUrl: String)