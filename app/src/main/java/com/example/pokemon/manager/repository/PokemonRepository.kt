package com.example.pokemon.manager.repository

import com.example.pokemon.manager.service.PokemonAPI
import com.example.pokemon.model.Pokemon
import com.example.pokemon.model.Pokemons
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PokemonRepository @Inject constructor(private val api: PokemonAPI) {
    suspend fun getPokemons(): Pokemons = api.getPokemons()
    suspend fun getPokemonById(id: Int): Pokemon = api.getPokemonById(id)
}