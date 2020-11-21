package com.mvvm.sample.data.source.remote

import com.mvvm.sample.data.source.remote.reponses.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface UsersWebService {
    companion object {

        /**
         * @return the base url of [UsersWebService]
         */

        // Usually differs by environment but for simplicity just the return the production url
        fun baseURL(): String = "https://jsonplaceholder.typicode.com/"
    }

    @GET(Paths.USERS_PATH)
    fun getUsers(): Observable<List<UserResponse>>

}