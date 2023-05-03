package com.example.myapp.data.ui.view

import android.app.DownloadManager.Request
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_rickandmorty.R
import com.example.myapp.CharacterAdapter
import com.example.myapp.data.model.GetCharacterByIdResponse
import com.example.myapp.data.network.CharacterRepository
import retrofit2.Response


class MainActivity:AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }
private fun initRecyclerView(){
    val recyclerView=findViewById<RecyclerView>(R.id.recyclerViewMain)
    recyclerView.layoutManager=LinearLayoutManager(this)
    recyclerView.adapter=CharacterAdapter(CharacterProvider.CharacterList)

    //yo no tengo un character provider. es un objeto donde están metidos los personajes (a fueego)
}
}