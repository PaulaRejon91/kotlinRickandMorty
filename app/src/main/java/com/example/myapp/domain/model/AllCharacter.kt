package com.example.myapp.domain.model

import com.example.myapp.data.model.CharacterLocationModel
import com.example.myapp.data.model.CharacterModel
import com.example.myapp.data.model.CharacterOriginModel
import com.google.gson.annotations.SerializedName

data class AllCharacter (

    @SerializedName("id") val characterId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("image") val image: String,
    @SerializedName("origin") val origin: CharacterOriginModel,
    @SerializedName("location") val location: CharacterLocationModel,
    )


fun CharacterModel.toDomain()=AllCharacter(characterId, name, status, image, origin, location)