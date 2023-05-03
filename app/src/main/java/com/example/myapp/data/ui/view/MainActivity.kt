package com.example.myapp.data.ui.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.myapp.data.model.GetCharacterByIdResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.example.app_rickandmorty.R
import com.example.myapp.data.network.NetworkLayer
import com.example.myapp.data.network.RickAndMortyService
import com.example.myapp.data.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameTextView = findViewById<TextView>(R.id.tvName)
        val headerImageView = findViewById<ImageView>(R.id.headerImageView)
        val aliveTextView = findViewById<TextView>(R.id.aliveTextView)
        val originTextView = findViewById<TextView>(R.id.originTextView)
        val speciesTextView = findViewById<TextView>(R.id.speciesTextView)
        val genderImageView = findViewById<ImageView>(R.id.genderImageView)

        viewModel.refreshCharacter(10)
        viewModel.characterByIdLiveData.observe(this) { response->
            if (response == null) {
                Toast.makeText(
                    this@MainActivity,
                    "llamada sin éxito!",
                    Toast.LENGTH_SHORT
                ).show()
                return@observe
            }
                  nameTextView.text = response.name
                aliveTextView.text=response.status
                speciesTextView.text=response.species
                originTextView.text=response.origin.name

            if(response.gender.equals("male,true")){
                genderImageView.setImageResource(R.drawable.ic_male_24)
                }else{
                genderImageView.setImageResource(R.drawable.ic_female_24)
            }
      Picasso.get().load(response.image).into(headerImageView)

        }
    }
}
