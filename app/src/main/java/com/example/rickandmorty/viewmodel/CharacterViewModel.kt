package com.example.rickandmorty.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.api.RestApiTask
import com.example.rickandmorty.model.Character
import com.example.rickandmorty.repositoy.CharacterRepository
import java.lang.Exception

class CharacterViewModel: ViewModel() {

    companion object{
        const val TAG = "Repository"
    }

    private val restApiTask = RestApiTask()
    private val characterRepository = CharacterRepository(restApiTask)


    private var _characterList = MutableLiveData<List<Character>>()
    val characterList: LiveData<List<Character>>
    get() = _characterList


    fun init() {
        getAllCharacter()

    }

    private fun getAllCharacter() {
        Thread{
            try {
                _characterList.postValue(characterRepository.getAllCharacter())
            }catch (exception: Exception){
                Log.d(TAG, exception.message.toString())
            }
        }.start()
    }








}