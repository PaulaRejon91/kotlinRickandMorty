package com.example.myapp.data.metwork


import com.example.myapp.data.model.GetCharacterByIdResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyService {

    @GET("character/2")
    fun getCharacterById():Call<Any>
}