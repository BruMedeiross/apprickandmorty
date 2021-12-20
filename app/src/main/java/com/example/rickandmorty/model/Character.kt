package com.example.rickandmorty.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Character (
    var id : Int,
    var name: String,
    var status : String,
    var species: String,
    var gender: String,
    var image : String?,
    var origin : LocationData,
    var location : LocationData,
    var episode : List<String>
): Parcelable