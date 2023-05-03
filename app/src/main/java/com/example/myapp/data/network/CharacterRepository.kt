package com.example.myapp.data.network

import com.example.myapp.data.model.GetCharacterByIdResponse

class CharacterRepository {
    suspend fun getCharacterById(characterId: Int): GetCharacterByIdResponse? {
        val request = NetworkLayer.apiClient.getCharacterById(characterId)

        if (request.isSuccessful) {
            return request.body()!!
        }
        return null
    }
}

    /*Dentro del método getCharacterById, se realiza una solicitud de red utilizando una instancia
    de NetworkLayer.apiClient. NetworkLayer es una clase que encapsula la configuración de la capa
    de red de la aplicación.  En este caso, se utiliza la instancia apiClient de NetworkLayer para
    realizar la solicitud.
     !! operador no nulo.
     */