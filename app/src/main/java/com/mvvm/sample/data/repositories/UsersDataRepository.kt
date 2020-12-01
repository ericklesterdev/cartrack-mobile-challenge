package com.mvvm.sample.data.repositories

import com.mvvm.sample.data.source.local.AppDatabase
import com.mvvm.sample.data.source.local.entities.AddressEntityDao
import com.mvvm.sample.data.source.local.entities.CompanyEntityDao
import com.mvvm.sample.data.source.local.entities.CompleteUserEntity
import com.mvvm.sample.data.source.local.entities.UserEntityDao
import com.mvvm.sample.data.source.remote.reponses.toComplUserEntity
import com.mvvm.sample.data.source.store.CloudUserStore
import com.mvvm.sample.domain.repositories.UsersRepository
import io.reactivex.Observable
import javax.inject.Inject

class UsersDataRepository @Inject constructor(
    private val cloudUserStore: CloudUserStore,
    localDb: AppDatabase
) : UsersRepository {

    private val userEntityDao: UserEntityDao = localDb.getUserEntityDao()
    private val addressEntityDao: AddressEntityDao = localDb.getAddressEntityDao()
    private val companyEntityDao: CompanyEntityDao = localDb.getCompanyEntityDao()

    override fun getUsers(
        page: Int,
        size: Int
    ): Observable<List<CompleteUserEntity>> {
        // GET Users from service, convert response to Entities ans Save to local DB
        return cloudUserStore.getUsers(page = page, size = size)
            .flatMapSingle { userResponse ->
                val complteUserEntities = userResponse.map { it.toComplUserEntity() }
                complteUserEntities.forEach {
                    userEntityDao.insert(it.userEntity!!)
                    addressEntityDao.saveAddress(it.addressEntity!!)
                    companyEntityDao.saveCompany(it.companyEntity!!)
                }
                userEntityDao.getUsers()
            }
    }
}