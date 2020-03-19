package com.khusainov.rinat.pokedex.presentation.ui.main.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khusainov.rinat.pokedex.data.mapper.PokemonMapper
import com.khusainov.rinat.pokedex.data.repository.PokemonRepository
import com.khusainov.rinat.pokedex.domain.interactor.IPokemonInteractor
import com.khusainov.rinat.pokedex.domain.interactor.PokemonInteractor
import com.khusainov.rinat.pokedex.domain.repository.IPokemonRepository
import com.khusainov.rinat.pokedex.presentation.ui.main.viewmodel.PokemonViewModel

class PokemonViewModelFactory(
    private val repository: IPokemonRepository = PokemonRepository(PokemonMapper()),
    private val interactor: IPokemonInteractor = PokemonInteractor(repository)
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonViewModel::class.java)) {
            return PokemonViewModel(interactor) as T
        }
        throw java.lang.IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}