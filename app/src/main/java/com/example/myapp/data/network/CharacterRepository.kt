package com.example.myapp.data.network

import com.example.myapp.data.model.AllCharacterModel
import com.example.myapp.data.model.CharacterModel
import com.example.myapp.data.model.GetCharacterByIdResponse
import com.example.myapp.domain.model.AllCharacter
import com.example.myapp.domain.model.toDomain
import javax.inject.Inject


class CharacterRepository @Inject constructor(private val apiClient: ApiClient) {
    suspend fun getCharacterById(characterId: Int): AllCharacter? {
        val response: CharacterModel? = apiClient.getCharacterById(characterId)
        return response?.toDomain()
    }

    suspend fun getCharacterByName(name: String): List<AllCharacter> {
    val response: AllCharacterModel? = apiClient.getAllCharacterByName(name)
    val listResponse: List<CharacterModel> = response!!.resultados
    return listResponse.map { it.toDomain() }
}

}





/*Dentro del método getCharacterById, se realiza una solicitud de red utilizando una instancia
de NetworkLayer.apiClient. NetworkLayer es una clase que encapsula la configuración de la capa
de red de la aplicación.  En este caso, se utiliza la instancia apiClient de NetworkLayer para
realizar la solicitud.
 !! operador no nulo.
 */