package com.khusainov.rinat.pokedex.presentation.ui.main.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.khusainov.rinat.pokedex.R
import com.khusainov.rinat.pokedex.domain.model.PokemonEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_list_item.view.*

class PokemonAdapter(private val pokemons: List<PokemonEntity>) :
    RecyclerView.Adapter<PokemonAdapter.PokemonHolder>() {

    class PokemonHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_item, parent, false)
        return PokemonHolder(view)
    }

    override fun getItemCount(): Int = pokemons.size

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        val pokemon: PokemonEntity = pokemons[position]
        holder.itemView.pokemonImageView.loadImage(pokemon.number)
    }

    private fun ImageView.loadImage(number: Int) {
        val parsedUrl =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$number.png"
        Picasso.get().load(parsedUrl).centerCrop().fit().into(this)
    }
}