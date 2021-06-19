package com.view.pokemonindex.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private object RetrofitConfig {
    // OkHttpClient is a service used to  prepare retrofit to make the call
    private val client = OkHttpClient.Builder().build()
    // a retrofit builder object contains the url for the pokeAPI  and a converter to convert from JSON
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    // interface passed on as a parameter to create a retrofit object
    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}