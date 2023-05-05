package com.example.myapp

import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.data.model.CharacterModel
import com.example.myapp.databinding.MainItemBinding
import com.squareup.picasso.Picasso
import javax.inject.Inject


class CharacterViewHolder@Inject constructor(val binding: MainItemBinding):
    RecyclerView.ViewHolder(binding.root){


    fun bind( characterListModel: CharacterModel, onItemSelected: (Int)-> Unit,) {
        binding.root.setOnClickListener { onItemSelected (characterListModel.characterId) }
        Picasso.get().load(characterListModel.image).into(binding.ivCharacter)
        binding.nameTextView.text = characterListModel.name
        binding.statusTextView.text = characterListModel.status
        binding.speciesTextView.text = characterListModel.species
        binding.originTextView.text= characterListModel.origin.origin

    }

}
