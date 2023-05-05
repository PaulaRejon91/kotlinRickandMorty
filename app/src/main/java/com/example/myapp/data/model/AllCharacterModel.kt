package com.example.myapp.data.model

import com.google.gson.annotations.SerializedName
import com.example.myapp.data.model.CharacterModel

data class AllCharacterModel (
    @SerializedName("results") val resultados: List<CharacterModel>
)
