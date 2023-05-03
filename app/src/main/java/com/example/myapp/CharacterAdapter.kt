package com.example.myapp
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_rickandmorty.R
import com.example.myapp.data.model.GetCharacterByIdResponse
import com.squareup.picasso.Picasso
import retrofit2.Response


//no sé si tengo que poner dentro getcharacterbyidresponse

class CharacterAdapter(private val characterList:List<GetCharacterByIdResponse>):RecyclerView.Adapter<CharacterViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
     return CharacterViewHolder(layoutInflater.inflate(R.layout.main_item,parent,false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

        val item= characterList[position]
        holder.render(item)
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