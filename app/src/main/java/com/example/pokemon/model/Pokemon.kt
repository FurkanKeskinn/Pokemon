package com.example.pokemon.model

import com.google.gson.annotations.SerializedName

data class Pokemon (
    val abilities: List<Ability>,
    val name : String,
    val sprites: Sprites
)
data class Ability (
    val ability: Species,
)
data class Species (
    val name: String,
    val url: String
)
data class Sprites(
    @SerializedName("front_default")
    val image: String
)
