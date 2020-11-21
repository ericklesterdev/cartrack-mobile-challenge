package com.mvvm.sample.data.source.local.entities

import androidx.room.*

@Dao
abstract class CompanyEntityDao : BaseDao<CompanyEntity> {

    @Query("""
        SELECT * FROM company
        WHERE userId = :userId
    """)
    internal abstract fun getCompanyByUserId(userId: Long): CompanyEntity?

    @Transaction
    open fun saveCompany(companyEntity: CompanyEntity): Long {

        val result = getCompanyByUserId(companyEntity.userId)

        return result?.let {
            companyEntity.id = result.id
            update(companyEntity)
            companyEntity.id
        } ?: run {
            insert(companyEntity)
        }
    }

    /**
     * Do not use directly in saving [CompanyEntity]
     *
     * Use [saveCompany] instead.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract fun insert(companyEntity: CompanyEntity): Long
}