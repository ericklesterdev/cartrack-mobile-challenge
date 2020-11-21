package com.mvvm.sample.data.source.local.entities

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import io.reactivex.Single


@Dao
abstract class UserEntityDao : BaseDao<UserEntity> {

    @Transaction
    @Query("SELECT * FROM user")
    abstract fun getUsers(): Single<List<CompleteUserEntity>>
}