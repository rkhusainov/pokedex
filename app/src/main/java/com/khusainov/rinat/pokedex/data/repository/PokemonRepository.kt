package com.khusainov.rinat.pokedex.data.repository

import com.khusainov.rinat.pokedex.data.mapper.IMapper
import com.khusainov.rinat.pokedex.data.model.Pokemon
import com.khusainov.rinat.pokedex.domain.model.PokemonEntity
import com.khusainov.rinat.pokedex.domain.repository.IPokemonRepository
import com.khusainov.rinat.pokedex.presentation.utils.ApiUtils

class PokemonRepository(
    private val pokemonMapper: IMapper<List<Pokemon>, List<PokemonEntity>>
) : IPokemonRepository {
    override suspend fun getPokemon(limit: Int, offset: Int): List<PokemonEntity> {
        return pokemonMapper.mapToEntity(
            ApiUtils.getApi().getPokemonResponse(limit, offset).results
        )
    }
}