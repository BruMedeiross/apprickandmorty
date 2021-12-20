package com.example.rickandmorty.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmorty.R
import com.example.rickandmorty.model.Character
import kotlinx.android.synthetic.main.character_item.view.*


class CharacterAdapter:
    RecyclerView.Adapter<CharacterViewHolder>() {

    private var characterList = emptyList<Character>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {


        holder.itemView.apply {
            characterTitle.text = characterList[position].name
            characterImage.load(characterList[position].image) {
                placeholder(R.drawable.ic_model2)
                fallback(R.drawable.ic_model2)
            }

            holder.itemView.setOnClickListener { view ->
                val action = ListFragmentDirections.actionListFragmentToDetailFragment(characterList[position])
                view.findNavController().navigate(action)
            }
        }
    }


    fun update(list: List<Character>) {
        characterList = list
        notifyDataSetChanged()

    }
    override fun getItemCount(): Int {
        return characterList.size
    }



}
