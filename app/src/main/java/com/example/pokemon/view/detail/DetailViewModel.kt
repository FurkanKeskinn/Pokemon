package com.example.pokemon.view.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.pokemon.manager.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: PokemonRepository): ViewModel() {
    fun getPokemonById(id: Int) = liveData(Dispatchers.IO) {
        try {
            val pokemon = repository.getPokemonById(id)
            emit(pokemon)
        }catch (e: Exception){
            emit(null)
            println(e.localizedMessage)
        }
    }
}