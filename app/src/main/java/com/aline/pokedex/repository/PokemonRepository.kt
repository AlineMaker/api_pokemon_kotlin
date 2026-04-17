package com.aline.pokedex.repository

import com.aline.pokedex.network.RetrofitInstance

class PokemonRepository {

    suspend fun getPokemon(nameOrId: String) =
        RetrofitInstance.api.getPokemon(nameOrId)
}