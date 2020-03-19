package com.khusainov.rinat.pokedex.presentation.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khusainov.rinat.pokedex.domain.interactor.IPokemonInteractor
import com.khusainov.rinat.pokedex.domain.model.PokemonEntity
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val interactor: IPokemonInteractor
) : ViewModel() {

    val pokemonLiveData = MutableLiveData<List<PokemonEntity>>()

    init {
        getPokemon()
    }

    private fun getPokemon() {
        viewModelScope.launch {
            val entity = interactor.getPokemon(63, 0)
            pokemonLiveData.value = entity
        }
    }
}