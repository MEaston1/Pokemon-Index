package com.view.pokemonindex.model
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
@Parcelize

class PokemonModel(val imageResId: String, val name: String, val abilities: String, val health: Int, val species: String) : Parcelable {
    constructor() : this ("", "", "", -1, "")
}