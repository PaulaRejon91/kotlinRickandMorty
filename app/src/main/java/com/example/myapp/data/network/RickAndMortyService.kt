package com.example.myapp.data.network


import com.example.myapp.data.model.AllCharacterModel
import com.example.myapp.data.model.CharacterModel
import com.example.myapp.data.model.GetCharacterByIdResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyService {

    @GET("character/{character-id}")
    suspend fun getCharacterById(
        @Path("character-id") characterId: Int
    ): Response<CharacterModel>

    @GET("character/")
    suspend fun getAllCharactersByName (@Query("name") name:String): Response<AllCharacterModel>
}