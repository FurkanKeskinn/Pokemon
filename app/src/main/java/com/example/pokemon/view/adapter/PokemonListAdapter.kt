package com.example.pokemon.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.databinding.RecycleListCellBinding
import com.example.pokemon.extensions.capitalize
import com.example.pokemon.model.Pokemons
import com.example.pokemon.model.Result
import com.squareup.picasso.Picasso

class PokemonListAdapter(
    val results: Pokemons,
    private val onItemClick: (Result) -> Unit
    ): RecyclerView.Adapter<PokemonListAdapter.PokemonsViewHolder>() {

    class PokemonsViewHolder(val binding: RecycleListCellBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonsViewHolder {
        val binding = RecycleListCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  results.results.size
    }

    override fun onBindViewHolder(holder: PokemonsViewHolder, position: Int) {
        val result = results.results[position]
        holder.binding.name.text = result.name.capitalize()
        Picasso.get().load(result.url).into(holder.binding.imageView)

        //we made for id
        holder.itemView.setOnClickListener{ onItemClick(result)}
    }

}
