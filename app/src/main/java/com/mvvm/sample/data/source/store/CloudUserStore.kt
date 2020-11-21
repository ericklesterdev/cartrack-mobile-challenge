package com.mvvm.sample.data.source.store

import com.mvvm.sample.data.source.remote.reponses.UserResponse
import io.reactivex.Observable

interface CloudUserStore {

    fun getUsers(
        page: Int,
        size: Int
    ): Observable<List<UserResponse>>
}