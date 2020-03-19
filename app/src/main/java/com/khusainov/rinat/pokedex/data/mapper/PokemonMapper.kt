package com.khusainov.rinat.pokedex.data.mapper

import com.khusainov.rinat.pokedex.data.model.Pokemon
import com.khusainov.rinat.pokedex.domain.model.PokemonEntity

class PokemonMapper : IMapper<List<Pokemon>, List<PokemonEntity>> {
    override fun mapToEntity(from: List<Pokemon>): List<PokemonEntity> {

        val pokemonList = mutableListOf<PokemonEntity>()

        for (pokemon in from) {
            val pokemonEntity = PokemonEntity(
                pokemon.number,
                pokemon.name,
                pokemon.url
            )

            pokemonList.add(pokemonEntity)
        }
        return pokemonList
    }
}