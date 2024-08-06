package com.example.pokemon.view.pokemonList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.pokemon.manager.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(private val repository: PokemonRepository): ViewModel() {

    fun getPokemons() = liveData(Dispatchers.IO) {
        try {
            val pokemon = repository.getPokemons()
            emit(pokemon)
        }catch (e: Exception){
            emit(null)
            println(e.localizedMessage)
        }
    }
}