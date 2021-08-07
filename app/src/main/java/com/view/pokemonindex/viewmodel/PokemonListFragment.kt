package com.view.pokemonindex.viewmodel

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.view.pokemonindex.R
import com.view.pokemonindex.databinding.PokemonModelBinding
import com.view.pokemonindex.model.PokemonModel
import kotlinx.android.synthetic.main.fragment_pokemon_list.*
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
    private lateinit var Health: IntArray
    private lateinit var pokemonSpecies: Array<String>
    private lateinit var listener: OnPokemonSelected

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_pokemon_list, container, false)
        val activity = activity as Context
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recycler_view.adapter = PokemonListAdapter(activity)
        return view
    }



    internal inner class PokemonListAdapter(context: Context) : RecyclerView.Adapter<ViewHolder>() {
        private val layoutInflater = LayoutInflater.from(context)
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val recyclerViewPokemonModelBinding = PokemonModelBinding.inflate(layoutInflater, parent, false)
            return ViewHolder(recyclerViewPokemonModelBinding.root, recyclerViewPokemonModelBinding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = PokemonModel(imageResIds[position], pokemonNames[position], pokemonAbilities[position], Health[position], pokemonSpecies[position])
            holder.setData(pokemon)
            holder.itemView.setOnClickListener { listener.onPokemonSelected(pokemon) }
        }

        override fun getItemCount(): Int {
            return pokemonNames.size
        }
    }
    internal inner class ViewHolder constructor(itemView: View, private val recyclerItemPokemonModelBinding: PokemonModelBinding) : RecyclerView.ViewHolder(itemView){
        fun setData(pokemonModel: PokemonModel){
            recyclerItemPokemonModelBinding.pokemonModel = pokemonModel
        }
    }

}