package com.example.rickandmorty

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.size
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmorty.model.Character
import kotlinx.android.synthetic.main.character_item.view.*


class CharacterAdapter(private var characterList:List<Character>) :
    RecyclerView.Adapter<CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.itemView.apply {
            characterTitle.text = characterList[position].name
            characterImage.load(characterList[position].image) {
                placeholder(R.drawable.ic_image)
                fallback(R.drawable.ic_image)
            }

            holder.itemView.setOnClickListener { view ->
                val action = ListFragmentDirections.actionListFragmentToDetailFragment()
                view.findNavController().navigate(action)
            }
        }
    }


    override fun getItemCount(): Int {
        return characterList.size
    }

    fun update(list: List<Character>) {
        characterList = list
    }


}
