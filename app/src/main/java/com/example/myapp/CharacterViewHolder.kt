package com.example.myapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_rickandmorty.R
import com.example.myapp.data.model.GetCharacterByIdResponse
import com.squareup.picasso.Picasso

class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val imageView = view.findViewById<TextView>(R.id.image_view)
    val nameTextView = view.findViewById<TextView>(R.id.name_text_view)
    val statusTextView = view.findViewById<TextView>(R.id.status_text_view)
    val speciesTextView = view.findViewById<TextView>(R.id.species_text_view)
    val originTextView = view.findViewById<TextView>(R.id.origin_text_view)

    fun render(characterListModel: GetCharacterByIdResponse) {
//        Picasso.get().load(characterListModel.image).into(imageView)
        nameTextView.text = characterListModel.name
        statusTextView.text = characterListModel.status
        speciesTextView.text = characterListModel.species
        originTextView.text = characterListModel.origin.name
    }

}
