package com.example.pokemon.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemon.view.adapter.DetailAdapter
import com.example.pokemon.databinding.FragmentDetailBinding
import com.example.pokemon.extensions.capitalize
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailViewModel by viewModels()

    var pokemonId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.abilitiesRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        arguments?.let {
            pokemonId = DetailFragmentArgs.fromBundle(it).id
        }

        viewModel.getPokemonById(pokemonId).observe(viewLifecycleOwner) { pokemon ->
            pokemon?.let {
                binding.nameTextView.text = pokemon.name.capitalize()
                pokemon.sprites.let {
                    Picasso.get().load(pokemon.sprites.image).into(binding.pokemonImageView)
                }
                binding.abilitiesRecyclerView.adapter = DetailAdapter(it.abilities)
            }
        }

        binding.imageButton.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailFragmentToPokemonListFragment()
            Navigation.findNavController(view).navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}