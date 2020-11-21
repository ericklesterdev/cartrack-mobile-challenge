package com.mvvm.sample.data.source.local.entities

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import io.reactivex.Completable

interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg obj: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplace(vararg obj: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(objs: List<T>)

    /**
     * Make sure that the field annotated with [androidx.room.PrimaryKey]
     * is populated before using this method.
     */
    @Update
    fun update(vararg obj: T)
}