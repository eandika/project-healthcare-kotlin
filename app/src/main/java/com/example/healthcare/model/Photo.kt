package com.example.healthcare.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("specialist")
    val specialist: String?,
    @SerializedName("image_url")
    val image_url: String?,
    @SerializedName("desc")
    val desc: String?
)
