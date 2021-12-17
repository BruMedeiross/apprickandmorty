package com.example.rickandmorty.api

import com.example.rickandmorty.model.CharacterList
import retrofit2.Call
import retrofit2.http.GET

interface Api {
        //https://rickandmortyapi.com/api/character
        //https://raw.githubusercontent.com/natanfelipe/FilmesFlixJson/master/moviesList

        @GET("api/character") //mudei aki
        fun getAllCharacter(): Call<CharacterList>

}