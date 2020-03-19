package com.khusainov.rinat.pokedex.domain.interactor

import com.khusainov.rinat.pokedex.domain.model.PokemonEntity

interface IPokemonInteractor {
    suspend fun getPokemon(limit: Int, offset: Int): List<PokemonEntity>
}