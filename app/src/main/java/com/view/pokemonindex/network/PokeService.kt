package com.view.pokemonindex.network

import com.view.pokemonindex.model.PokemonModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//Interface defines the endpoints of the PokeAPI
interface PokeService {
    @GET("pokemon/{name}/")
    fun getPokemon(@Query("api_key") key: String): Call<PokemonModel>
}