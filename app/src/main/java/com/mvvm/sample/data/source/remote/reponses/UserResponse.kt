package com.mvvm.sample.data.source.remote.reponses


import com.google.gson.annotations.SerializedName
import com.mvvm.sample.data.source.local.entities.CompleteUserEntity
import com.mvvm.sample.data.source.local.entities.UserEntity

fun UserResponse.toComplUserEntity(): CompleteUserEntity {
    val user =  UserEntity(
        id = this.id,
        email = this.email,
        name = this.name,
        phone = this.phone,
        username = this.username,
        website = this.website,
    )

    val complete = CompleteUserEntity()
    complete.userEntity = user
    complete.addressEntity = this.addressResponse.toAddressEntity(user.id)
    complete.companyEntity = this.companyResponse.toCompanyEntity(user.id)
    return complete
}

data class UserResponse(
    @SerializedName("address")
    val addressResponse: AddressResponse,
    @SerializedName("company")
    val companyResponse: CompanyResponse,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("website")
    val website: String
)