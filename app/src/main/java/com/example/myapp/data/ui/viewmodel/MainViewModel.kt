package com.example.myapp.data.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.data.model.GetCharacterByIdResponse
import com.example.myapp.data.network.CharacterRepository
import kotlinx.coroutines.launch
import okhttp3.Response

class MainViewModel : ViewModel() {
    private val repository = CharacterRepository()

    private val _characterByIdLiveData = MutableLiveData<GetCharacterByIdResponse>()
    val characterByIdLiveData: LiveData<GetCharacterByIdResponse?> = _characterByIdLiveData

    fun refreshCharacter(characterId: Int) {
        viewModelScope.launch {
            val response = repository.getCharacterById(characterId)

            _characterByIdLiveData.postValue(response)
        }
    }
}

/*En este código, la clase MainViewModel extiende la clase ViewModel y contiene
una instancia de la clase CharacterRepository que se utiliza para obtener información
de un personaje. La clase MainViewModel también contiene una instancia de la clase
MutableLiveData, _characterByIdLiveData, que es un objeto observable que permite que los
fragmentos y actividades de la aplicación observen los cambios en el objeto que contiene.
La clase LiveData es inmutable y solo puede ser leída, mientras que la clase MutableLiveData
permite la actualización de los valores.

Además, la clase MainViewModel tiene una propiedad pública llamada characterByIdLiveData que
es una instancia de LiveData<GetCharacterByIdResponse?>. Esta propiedad es la versión pública
de _characterByIdLiveData y permite que los fragmentos y actividades de la aplicación observen
los cambios en el objeto observable.

Dentro de la clase MainViewModel, se utiliza el método viewModelScope.launch para lanzar una nueva
corrutina en el ámbito de la vista del modelo. Dentro de la corrutina, se llama al método
getCharacterById del objeto repository, que es suspendido. Una vez que se recibe la respuesta de la red,
se actualiza el valor de _characterByIdLiveData utilizando el método setValue.

En resumen, la clase MainViewModel es responsable de manejar la lógica de la vista y la recuperación
de datos de la red, y utiliza instancias de MutableLiveData y LiveData para permitir que las actividades
y fragmentos de la aplicación observen los cambios en los datos recuperados de la red.
 */