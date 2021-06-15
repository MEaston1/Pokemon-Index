package com.view.pokemonindex.model

import java.io.Serializable

data class PokemonModel(val imageResId: Int, val name: String, val abilities: String, val species: String, val health: Int) : Serializable