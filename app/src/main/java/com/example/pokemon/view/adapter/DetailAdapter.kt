package com.example.pokemon.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemon.databinding.RecycleDetailCellBinding
import com.example.pokemon.extensions.capitalize
import com.example.pokemon.model.Ability

class DetailAdapter(
    val abilities: List<Ability>,
): RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    class DetailViewHolder(val binding: RecycleDetailCellBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val binding = RecycleDetailCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  abilities.size
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val ability = abilities[position]
        holder.binding.abilitiesTextView.text = "${position + 1} - ${ability.ability.name.capitalize()}"
    }
}