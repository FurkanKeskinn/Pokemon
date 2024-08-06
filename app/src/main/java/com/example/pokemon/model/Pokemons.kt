package com.example.pokemon.model

data class Pokemons (
    val results: List<Result>
)
data class Result (
    val name: String,
    val url: String
)
