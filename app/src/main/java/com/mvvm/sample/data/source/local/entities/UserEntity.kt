package com.mvvm.sample.data.source.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val id: Long = 0L,
    val email: String,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)