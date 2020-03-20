package com.khusainov.rinat.pokedex.presentation.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.khusainov.rinat.pokedex.Constants.OFFSET_STEP
import com.khusainov.rinat.pokedex.Constants.PAGE_LIMIT
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

    private var offset = 0
    private lateinit var viewModelFactory: PokemonViewModelFactory
    private lateinit var viewModel: PokemonViewModel
    private lateinit var pokemonAdapter: PokemonAdapter

    override fun onStart() {
        super.onStart()
        viewModel.getPokemon(offset)
        offset += OFFSET_STEP
    }

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

        pokemon_recycler_view.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val visibleItemCount: Int =
                    (pokemon_recycler_view.layoutManager as GridLayoutManager).childCount
                val totalItemCount: Int =
                    (pokemon_recycler_view.layoutManager as GridLayoutManager).itemCount
                val firstVisibleItemPosition: Int =
                    (pokemon_recycler_view.layoutManager as GridLayoutManager).findFirstVisibleItemPosition()

                if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                    && firstVisibleItemPosition >= 0
                    && totalItemCount >= PAGE_LIMIT
                ) {
                    loadMoreItems();
                }
            }
        })

        pokemonAdapter = PokemonAdapter()
        pokemon_recycler_view.adapter = pokemonAdapter
    }

    private fun loadMoreItems() {
        viewModel.getPokemon(offset)
        offset += OFFSET_STEP
    }

    private fun setupMVVM() {
        viewModelFactory = PokemonViewModelFactory()
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PokemonViewModel::class.java)
        viewModel.pokemonLiveData.observe(this, object : Observer<List<PokemonEntity>> {
            override fun onChanged(pokemonList: List<PokemonEntity>?) {
                pokemonAdapter.bindData(pokemonList ?: emptyList())
            }
        })
    }
}
