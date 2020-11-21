package com.mvvm.sample.data.source.remote.reponses


import com.google.gson.annotations.SerializedName
import com.mvvm.sample.data.source.local.entities.AddressEntity

fun AddressResponse.toAddressEntity(userId: Long): AddressEntity {
    return AddressEntity(
        city = this.city,
        street = this.street,
        suite = this.suite,
        zipCode = this.zipCode,
        lat = this.geoLocationResponse?.lat ?: "0",
        lng = this.geoLocationResponse?.lng ?: "0",
        userId = userId
    )
}

data class AddressResponse(
    @SerializedName("city")
    val city: String,
    @SerializedName("geo")
    val geoLocationResponse: GeoLocationResponse?,
    @SerializedName("street")
    val street: String,
    @SerializedName("suite")
    val suite: String,
    @SerializedName("zipcode")
    val zipCode: String
)