package com.mvvm.sample.data.source.local.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "company",
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("userId")]
)
data class CompanyEntity(
    @PrimaryKey(autoGenerate = true) var id: Long = 0L,
    val name: String,
    val catchPhrase: String,
    val bs: String,
    val userId: Long
)