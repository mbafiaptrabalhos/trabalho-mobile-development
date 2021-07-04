package br.com.fiap.trabalho_mobile_development.repository

import br.com.fiap.trabalho_mobile_development.model.Pokemon
import br.com.fiap.trabalho_mobile_development.model.PokemonResponse

interface PokemonRepository {
    fun getPokemons(
        offset: Int,
        limit: Int,
        onComplete: (PokemonResponse?) -> Unit,
        onError: (Throwable?) -> Unit
    )

    fun getPokemonsById(
        id: String,
        onComplete: (Pokemon?) -> Unit,
        onError: (Throwable?) -> Unit
    )
}

