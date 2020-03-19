package com.khusainov.rinat.pokedex.data.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("results") val results: List<Pokemon>
)