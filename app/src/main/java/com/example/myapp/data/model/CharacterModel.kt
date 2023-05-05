package com.example.myapp.data.model

import com.google.gson.annotations.SerializedName

data class CharacterModel(
    @SerializedName("id") val characterId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("image") val image: String,
    @SerializedName("origin") val origin: CharacterOriginModel,
    @SerializedName("location") val location: CharacterLocationModel,
    @SerializedName("species") val species: String,

    )

data class CharacterOriginModel(
    @SerializedName("name") val origin: String,
)
data class CharacterLocationModel(
    @SerializedName("name") val location: String
)