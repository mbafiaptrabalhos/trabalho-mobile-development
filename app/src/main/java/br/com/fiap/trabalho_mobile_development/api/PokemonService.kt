package br.com.fiap.trabalho_mobile_development.api

import br.com.fiap.trabalho_mobile_development.model.Pokemon
import retrofit2.Call
import br.com.fiap.trabalho_mobile_development.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {

    @GET("/api/v2/pokemon")
    fun getPokemons(
        @Query("offset") size: Int,
        @Query("limit") sort: Int
    ) : Call<PokemonResponse>

    @GET("/api/v2/pokemon/{id}/")
    fun getPokemonById(@Path("id") id: String) : Call<Pokemon>
}