package com.mvvm.sample.data.source.remote.reponses


import com.google.gson.annotations.SerializedName

data class GeoLocationResponse(
    @SerializedName("lat")
    val lat: String?,
    @SerializedName("lng")
    val lng: String?
)