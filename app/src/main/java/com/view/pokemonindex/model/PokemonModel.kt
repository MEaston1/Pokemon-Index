package com.view.pokemonindex.model

import java.io.Serializable

class PokemonModel(val imageResId: Int, val name: String, val abilities: String, val health: Int, val species: String) : Serializable