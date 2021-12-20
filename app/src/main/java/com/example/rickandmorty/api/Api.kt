package com.example.rickandmorty.api

import com.example.rickandmorty.model.CharacterList
import retrofit2.Call
import retrofit2.http.GET

interface Api {
        @GET("api/character")
        fun getAllCharacter(): Call<CharacterList>
}
//https://rickandmortyapi.com/api/character