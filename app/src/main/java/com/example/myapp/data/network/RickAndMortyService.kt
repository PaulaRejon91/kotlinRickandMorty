package com.example.myapp.data.network


import com.example.myapp.data.model.GetCharacterByIdResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyService {

    @GET("character/{character-id}")
    suspend fun getCharacterById(
        @Path("character-id") characterId: Int
    ): Response<GetCharacterByIdResponse>

    @GET("character/")
    suspend fun getAllCharacter(
        @Path("character") character:Int
    ): Response<GetCharacterByIdResponse>
}