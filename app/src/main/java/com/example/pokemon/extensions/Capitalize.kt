package com.example.pokemon.extensions

import java.util.Locale

fun String.capitalize(): String {
    return if (isNotEmpty() && this[0].isLowerCase()) substring(0, 1).uppercase(Locale.ROOT) + substring(1) else this
}