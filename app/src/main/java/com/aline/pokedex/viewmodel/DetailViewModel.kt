package com.aline.pokedex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aline.pokedex.model.PokemonDetail
import com.aline.pokedex.repository.PokemonRepository
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val repository = PokemonRepository()

    private val _pokemon = MutableLiveData<PokemonDetail>()
    val pokemon: LiveData<PokemonDetail> = _pokemon

    fun buscarPokemon(nome: String) {
        viewModelScope.launch {
            try {
                _pokemon.value = repository.getPokemon(nome)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}