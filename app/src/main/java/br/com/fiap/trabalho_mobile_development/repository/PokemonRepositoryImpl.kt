package br.com.fiap.trabalho_mobile_development.repository

import br.com.fiap.trabalho_mobile_development.api.PokemonService
import br.com.fiap.trabalho_mobile_development.model.Pokemon
import br.com.fiap.trabalho_mobile_development.model.PokemonResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepositoryImpl(val pokemonService: PokemonService) : PokemonRepository {

    override fun getPokemons(
        offset: Int,
        limit: Int,
        onComplete: (PokemonResponse?) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        pokemonService.getPokemons(offset, limit)
            .enqueue(object : Callback<PokemonResponse> {
                override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(
                    call: Call<PokemonResponse>, response:
                    Response<PokemonResponse>
                ) {
                    if (response.isSuccessful) {
                        onComplete(response.body())
                    } else {
                        onError(Throwable("Não foi possível carregar os Pokémons"))
                    }
                }
            })
    }

    override fun getPokemonsById(
        id: String,
        onComplete: (Pokemon?) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        pokemonService.getPokemonById(id)
            .enqueue(object : Callback<Pokemon> {
                override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(
                    call: Call<Pokemon>, response:
                    Response<Pokemon>
                ) {
                    if (response.isSuccessful) {
                        onComplete(response?.body())
                    } else {
                        onError(Throwable("Não foi possível carregar os Pokémons"))
                    }
                }
            })
    }
}