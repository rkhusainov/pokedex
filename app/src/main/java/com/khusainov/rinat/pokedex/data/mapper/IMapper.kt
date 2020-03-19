package com.khusainov.rinat.pokedex.data.mapper

interface IMapper<From, To> {
    fun mapToEntity(from: From): To
}