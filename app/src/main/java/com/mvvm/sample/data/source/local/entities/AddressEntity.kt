package com.mvvm.sample.data.source.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "address",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("userId")]
)
data class AddressEntity(
    @PrimaryKey(autoGenerate = true) var id: Long = 0L,
    val city: String,
    val street: String,
    val suite: String,
    val zipCode: String,
    val lat: String,
    val lng: String,
    val userId: Long
)