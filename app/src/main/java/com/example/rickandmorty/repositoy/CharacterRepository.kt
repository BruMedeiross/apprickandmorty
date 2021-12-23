package com.example.rickandmorty.repositoy

import android.util.Log
import com.example.rickandmorty.api.RestApiTask
import com.example.rickandmorty.model.Character
//ponte para o data source
class CharacterRepository(private val restApiTask: RestApiTask) {

    companion object{
        const val TAG = "Repository"
    }
    private  val characterList = arrayListOf<Character>()

    fun getAllCharacter(): List<Character>{
        val request = restApiTask.retrofitApi().getAllCharacter().execute()

        if (request.isSuccessful){
            request.body()?.let {
                characterList.addAll(it.results)
            }

        }else{
            request.body()?.let {
                Log.d(TAG, it.toString())
            }
        }
        return characterList

    }





}