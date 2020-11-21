package com.mvvm.sample.domain.repositories

import com.mvvm.sample.data.source.local.entities.CompleteUserEntity
import io.reactivex.Observable

interface UsersRepository {

    fun getUsers(
        page: Int,
        size: Int
    ): Observable<List<CompleteUserEntity>>
}