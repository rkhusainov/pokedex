package com.khusainov.rinat.pokedex.domain.repository

import com.khusainov.rinat.pokedex.domain.model.PokemonEntity

interface IPokemonRepository {
    suspend fun getPokemon(limit: Int, offset: Int): List<PokemonEntity>
}