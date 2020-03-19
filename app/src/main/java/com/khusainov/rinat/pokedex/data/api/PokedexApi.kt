package com.khusainov.rinat.pokedex.data.api

import com.khusainov.rinat.pokedex.data.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokedexApi {
    @GET("pokemon")
    suspend fun getPokemonResponse(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonResponse
}