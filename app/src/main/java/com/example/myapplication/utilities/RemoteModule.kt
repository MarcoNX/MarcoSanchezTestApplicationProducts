package com.example.myapplication.utilities

import com.example.myapplication.data.remote.ProductsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        val protocols = arrayListOf<Protocol>()
        protocols.add(Protocol.HTTP_1_1)
        val inteceptor = HttpLoggingInterceptor()
        inteceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(inteceptor)
            .protocols(protocols)
            .build()
        return Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun getProductServices(retrofit: Retrofit):ProductsService{
        return retrofit.create(ProductsService::class.java)
    }
}