package com.example.myapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.data.model.CharacterModel
import com.example.myapp.databinding.MainItemBinding
import javax.inject.Inject


class CharacterAdapter @Inject constructor(var characterList: List<CharacterModel> = emptyList(),private val onItemSelected: (Int) -> Unit) :
    RecyclerView.Adapter<CharacterViewHolder>() {

    fun refreshList(list: List<CharacterModel>) {
        this.characterList = list
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = MainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CharacterViewHolder(binding)
    }


    override fun onBindViewHolder(viewholder: CharacterViewHolder, position: Int) {

        var item = characterList[position]
        viewholder.bind(item,onItemSelected)
    }

    override fun getItemCount(): Int {
        return characterList.size
    }
}


//
//class CharacterAdapter (private val itemList: List<String>) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(itemList[position])
//    }
//
//    override fun getItemCount(): Int = itemList.size
//
//    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        fun bind(item: String) {
//            itemView.itemTextView.text = item
//        }
//    }
//}