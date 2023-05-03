package com.example.myapp.data.network

import com.example.myapp.data.model.GetCharacterByIdResponse
import retrofit2.Response

class ApiClient(
    private val rickAndMortyService: RickAndMortyService
) {
    suspend fun getCharacterById(characterId: Int): Response<GetCharacterByIdResponse> {
        return rickAndMortyService.getCharacterById(characterId)
    }
}