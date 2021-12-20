package com.example.rickandmorty


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment(R.layout.fragment_detail)  {

    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val character = args.character

        textEposides.text = character.episode.size.toString()
        textStatus.text = character.status
        Picasso.get().load(character.image).into(characterImage)
        textName.text = character.name
        textSpecies.text = character.species
        textGender.text = character.gender
        textOrigin.text = character.origin.name
        textLocation.text = character.location.name

    }

}