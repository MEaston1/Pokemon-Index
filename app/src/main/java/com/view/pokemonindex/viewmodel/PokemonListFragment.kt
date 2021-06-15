package com.view.pokemonindex.viewmodel

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.view.pokemonindex.databinding.FragmentPokemonListBinding

/**
 * Use the [PokemonListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokemonListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var imageResIds: IntArray
    private lateinit var pokemonNames: Array<String>
    private lateinit var pokemonDescriptions: Array<String>
    private lateinit var pokemonHP: IntArray
    private lateinit var pokemonSpecies: Array<String>
    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = _binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonListBinding.inflate(inflater, container, false)
        val view = binding?.root
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance():
            PokemonListFragment {
            return PokemonListFragment()
        }
    }
}