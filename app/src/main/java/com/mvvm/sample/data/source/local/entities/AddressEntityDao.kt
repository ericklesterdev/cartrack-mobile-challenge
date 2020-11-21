package com.mvvm.sample.data.source.local.entities

import androidx.room.*

@Dao
abstract class AddressEntityDao  : BaseDao<AddressEntity> {

    @Query("""
        SELECT * FROM address
        WHERE userId = :userId
    """)
    internal abstract fun getAddressByUserId(userId: Long): AddressEntity?

    @Transaction
    open fun saveAddress(addressEntity: AddressEntity): Long {

        val result = getAddressByUserId(addressEntity.userId)

        return result?.let {
            addressEntity.id = result.id
            update(addressEntity)
            addressEntity.id
        } ?: run {
            insert(addressEntity)
        }
    }

    /**
     * Do not use directly in saving [AddressEntity]
     *
     * Use [saveAddress] instead.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract fun insert(addressEntity: AddressEntity): Long
}