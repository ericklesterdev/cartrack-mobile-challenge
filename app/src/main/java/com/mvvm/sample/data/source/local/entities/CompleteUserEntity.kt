package com.mvvm.sample.data.source.local.entities

import androidx.room.Embedded
import androidx.room.Relation

class CompleteUserEntity {

    @Embedded
    var userEntity: UserEntity? = null

    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    var addressEntity: AddressEntity? = null

    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    var companyEntity: CompanyEntity? = null
}