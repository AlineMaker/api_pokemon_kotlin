package com.aline.pokedex.viewmodel

import androidx.lifecycle.*
import com.aline.pokedex.model.PokemonDetail
import com.aline.pokedex.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    private val repository = PokemonRepository()

   // private val _pokemon = MutableLiveData<PokemonDetail>()

    private val _pokemons = MutableLiveData<List<PokemonDetail>>(emptyList())
    val pokemons: LiveData<List<PokemonDetail>> = _pokemons
    //val pokemon: LiveData<PokemonDetail> = _pokemon

    fun buscarPokemon(nomeOuId: String) {
        viewModelScope.launch {
            try {
                val response = repository.getPokemon(nomeOuId)
               // _pokemon.value = response

                val listaAtual = _pokemons.value ?: emptyList()

                _pokemons.value = listOf(response) + listaAtual
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}