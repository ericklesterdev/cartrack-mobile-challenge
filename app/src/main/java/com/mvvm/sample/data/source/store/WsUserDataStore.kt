package com.mvvm.sample.data.source.store

import com.mvvm.sample.data.source.remote.UsersWebService
import com.mvvm.sample.data.source.remote.reponses.UserResponse
import io.reactivex.Observable
import javax.inject.Inject

class WsUserDataStore  @Inject constructor(private val usersWebService: UsersWebService) : CloudUserStore {

    override fun getUsers(
        page: Int,
        size: Int
    ): Observable<List<UserResponse>> {
        // TODO implement pagination when it is supported by web service.

        //  I can't implement a pagination at the moment since the app is just retrieving static data.
        return usersWebService.getUsers()
    }
}
