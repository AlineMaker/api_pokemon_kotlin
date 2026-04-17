package com.aline.pokedex.network

import com.aline.pokedex.model.PokemonDetail
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {

    // 🔥 BUSCA POR NOME OU ID
    @GET("pokemon/{nameOrId}")
    suspend fun getPokemon(
        @Path("nameOrId") nameOrId: String
    ): PokemonDetail
}