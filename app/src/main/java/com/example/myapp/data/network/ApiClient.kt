package com.example.myapp.data.network

import android.app.DownloadManager.Query
import com.example.myapp.data.model.AllCharacterModel
import com.example.myapp.data.model.CharacterModel
import com.example.myapp.data.model.GetCharacterByIdResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ApiClient(
    private val rickAndMortyService: RickAndMortyService
) {
    suspend fun getCharacterById(characterId: Int): CharacterModel? {
        return withContext(Dispatchers.IO) {
            val response: Response<CharacterModel> =
                rickAndMortyService.getCharacterById(characterId)
            response.body()
        }
    }

    suspend fun getAllCharacterByName(name: String): AllCharacterModel? {
        return withContext(Dispatchers.IO) {
            val response: Response<AllCharacterModel> = rickAndMortyService.getAllCharactersByName(name)
            response.body() ?: AllCharacterModel(emptyList())

        }
    }
}
