package com.aline.pokedex.viewmodel

import androidx.lifecycle.*
import com.aline.pokedex.model.PokemonDetail
import com.aline.pokedex.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    private val repository = PokemonRepository()

    private val _pokemon = MutableLiveData<PokemonDetail>()
    val pokemon: LiveData<PokemonDetail> = _pokemon

    fun buscarPokemon(nomeOuId: String) {
        viewModelScope.launch {
            try {
                val response = repository.getPokemon(nomeOuId)
                _pokemon.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}