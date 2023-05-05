package com.example.myapp.ui.view


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.myapp.data.model.CharacterModel
import com.example.myapp.data.network.NetworkLayer
import com.example.myapp.databinding.ActivityCharacterBinding

import com.example.myapp.ui.viewmodel.CharacterViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit


@AndroidEntryPoint
class CharacterActivity : AppCompatActivity() {
    companion object {
        const val CHARACTER_ID = "character_id"
    }

    private var retrofit: Retrofit = NetworkLayer.provideRetrofit()
    private var retrofitApi = NetworkLayer.provideCharacterApiClient(retrofit)

    private lateinit var binding: ActivityCharacterBinding

    val viewModel: CharacterViewModel by lazy {
        ViewModelProvider(this).get(CharacterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id: Int = intent.getIntExtra(CHARACTER_ID,0)
        getCharacterDetail(id)


    }

    private fun createdUI(response: CharacterModel) {
        Picasso.get().load(response.image).into(binding.headerImageView)
        binding.aliveTextView.text=response.status
        binding.speciesTextView.text=response.species
        binding.originLabelTextView.text=response.origin.origin
        binding.tvName.text=response.name


    }

    private fun getCharacterDetail(id: Int) {

        CoroutineScope(Dispatchers.IO).launch {
            val characterDetail: Response<CharacterModel> =
                retrofitApi.getCharacterById(id)


            if (characterDetail.isSuccessful) {
                val response: CharacterModel? = characterDetail.body()

                if (response != null) {

                    runOnUiThread {
                        createdUI(response!!)

                    }
                }
            }
        }
    }
}
