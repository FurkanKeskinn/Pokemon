package com.example.pokemon.manager.service

import com.example.pokemon.model.Pokemon
import com.example.pokemon.model.Pokemons
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAPI {
    @GET("pokemon/")
    suspend fun getPokemons(): Pokemons

    @GET("pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Int): Pokemon
}