package com.example.myapp.ui.view

import android.app.DownloadManager.Request
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.CharacterAdapter
import com.example.myapp.data.model.AllCharacterModel
import com.example.myapp.data.model.CharacterModel
import com.example.myapp.data.model.GetCharacterByIdResponse
import com.example.myapp.data.network.CharacterRepository
import com.example.myapp.data.network.NetworkLayer
import com.example.myapp.data.network.RickAndMortyService
import com.example.myapp.databinding.ActivityMainBinding
import com.example.myapp.ui.view.CharacterActivity.Companion.CHARACTER_ID
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {



    private var retrofit: Retrofit = NetworkLayer.provideRetrofit()
    private var retrofitApi = NetworkLayer.provideCharacterApiClient(retrofit)

    private lateinit var adapter: CharacterAdapter

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        searchCharacter("a") //para que recargue una lista sin poner nada en searchview
        initRecyclerView()
    }

    private fun searchCharacter(query: String) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<AllCharacterModel> = retrofitApi.getAllCharactersByName(query)

            if (call.isSuccessful) {
                val response: AllCharacterModel? = call.body()
                if (response != null) {
                    runOnUiThread {
                        adapter.refreshList(response.resultados)
                        binding.progressBar.isVisible = false
                    }
                }
            }

        }
    }

    private fun initRecyclerView() {
        adapter = CharacterAdapter{characterId -> navegateToDetail(characterId)}
        binding.recyclerViewMain.setHasFixedSize(true)
        binding.recyclerViewMain.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewMain.adapter = adapter
        binding.searchViewCharacters.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {

                searchCharacter(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?) = false
        })
    }

    private fun navegateToDetail(characterId: Int) {

        val intent = Intent(this,CharacterActivity::class.java)
        intent.putExtra(CHARACTER_ID,characterId)
        startActivity(intent)

    }
}