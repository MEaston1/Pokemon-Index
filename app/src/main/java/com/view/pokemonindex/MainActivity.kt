package com.view.pokemonindex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.view.pokemonindex.model.PokemonModel
import kotlinx.android.synthetic.main.fragment_pokemon_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val request = ServiceBuilder.buildservice(PokemonModel::class.java)
        val call = request.getPokemon(getString(R.string.api_key))

        call.enqueue(object : Callback<PokemonModel>{
            override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>) {
                if (response.isSuccessful){
                    recycler_view.apply {
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        // reference adapter here
                        adapter = PokemonAdapter(response.body()!!.results)         // TODO create adapter
                    }
                }
            }

            override fun onFailure(call: Call<PokemonModel>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}