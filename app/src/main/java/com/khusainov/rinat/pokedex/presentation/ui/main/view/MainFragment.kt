package com.khusainov.rinat.pokedex.presentation.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.khusainov.rinat.pokedex.R
import com.khusainov.rinat.pokedex.domain.model.PokemonEntity
import com.khusainov.rinat.pokedex.presentation.ui.main.factory.PokemonViewModelFactory
import com.khusainov.rinat.pokedex.presentation.ui.main.viewmodel.PokemonViewModel
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    private lateinit var viewModelFactory: PokemonViewModelFactory
    private lateinit var viewModel: PokemonViewModel
    private lateinit var pokemonAdapter: PokemonAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupMVVM()
        pokemon_recycler_view.layoutManager = (GridLayoutManager(context, 3))
    }

    private fun setupMVVM() {
        viewModelFactory = PokemonViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PokemonViewModel::class.java)
        viewModel.pokemonLiveData.observe(this, object : Observer<List<PokemonEntity>> {
            override fun onChanged(pokemons: List<PokemonEntity>?) {
                pokemonAdapter = PokemonAdapter(pokemons ?: emptyList())
                pokemon_recycler_view.adapter = pokemonAdapter
            }
        })
    }
}
