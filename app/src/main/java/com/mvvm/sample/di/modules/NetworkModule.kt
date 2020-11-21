package com.mvvm.sample.di.modules

import android.content.Context
import com.google.gson.GsonBuilder
import com.mvvm.sample.data.source.remote.UsersWebService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(context: Context): OkHttpClient {
        val builder = OkHttpClient.Builder()

        // Enable response caching. Will activate when response header has max-age.
//        val cacheSize: Long = 10 * 1024 * 1024 // 10MB
//        val cache = Cache(context.cacheDir, cacheSize)
//        builder.cache(cache)

        return builder.build()
    }


    @Provides
    @Singleton
    fun provideUsersWebService(httpClient: OkHttpClient): UsersWebService {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .baseUrl(UsersWebService.baseURL())
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(UsersWebService::class.java)
    }
}