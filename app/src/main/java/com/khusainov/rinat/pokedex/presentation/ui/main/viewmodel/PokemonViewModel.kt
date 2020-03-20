package com.khusainov.rinat.pokedex.presentation.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khusainov.rinat.pokedex.Constants.PAGE_LIMIT
import com.khusainov.rinat.pokedex.domain.interactor.IPokemonInteractor
import com.khusainov.rinat.pokedex.domain.model.PokemonEntity
import kotlinx.coroutines.launch

class PokemonViewModel(
    private val interactor: IPokemonInteractor
) : ViewModel() {

    val pokemonLiveData = MutableLiveData<List<PokemonEntity>>()

    fun getPokemon(offset:Int) {
        viewModelScope.launch {
            val entity = interactor.getPokemon(PAGE_LIMIT, offset)
            pokemonLiveData.value = entity
        }
    }
}