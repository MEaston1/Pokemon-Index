package com.view.pokemonindex.viewmodel

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.view.pokemonindex.databinding.FragmentPokemonListBinding
import com.view.pokemonindex.model.PokemonModel
import java.lang.ClassCastException
import java.util.*

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
    private lateinit var pokemonAbilities: Array<String>
    private lateinit var pokemonHP: IntArray
    private lateinit var pokemonSpecies: Array<String>
    private lateinit var listener: OnPokemonSelected
    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = _binding

    companion object {
        @JvmStatic
        fun newInstance():
                PokemonListFragment {
            return PokemonListFragment()
        }
    }
    interface OnPokemonSelected {
        fun onPokemonSelected(pokemonModel: PokemonModel){

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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnPokemonSelected){
            listener = context
        } else {
            throw ClassCastException(context.toString() + " must implement OnPokemonSelected.")
        }
        val resources = context.resources
        //pokemonNames = resources.getStringArray(R.arr)
        // -- add retrofit reference here to access resources from PokeAPI
    }

}