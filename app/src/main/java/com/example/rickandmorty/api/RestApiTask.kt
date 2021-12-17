package com.example.rickandmorty.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestApiTask {

    companion object{
        const val BASE_URL= "https://rickandmortyapi.com/" //mudei aki
    }

    private fun characterProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun retrofitApi() : Api = characterProvider().create(Api::class.java)
}