package com.khusainov.rinat.pokedex.domain.interactor

import com.khusainov.rinat.pokedex.domain.model.PokemonEntity
import com.khusainov.rinat.pokedex.domain.repository.IPokemonRepository

class PokemonInteractor(private val repository: IPokemonRepository) : IPokemonInteractor {
    override suspend fun getPokemon(limit: Int, offset: Int): List<PokemonEntity> =
        repository.getPokemon(limit, offset)
}