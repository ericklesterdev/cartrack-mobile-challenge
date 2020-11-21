package com.mvvm.sample.data.source.remote.reponses


import com.google.gson.annotations.SerializedName
import com.mvvm.sample.data.source.local.entities.CompanyEntity

fun CompanyResponse.toCompanyEntity(userId: Long): CompanyEntity {
    return CompanyEntity(
        name = this.name,
        catchPhrase = this.catchPhrase,
        bs = this.bs,
        userId = userId
    )
}

data class CompanyResponse(
    @SerializedName("bs")
    val bs: String,
    @SerializedName("catchPhrase")
    val catchPhrase: String,
    @SerializedName("name")
    val name: String
)