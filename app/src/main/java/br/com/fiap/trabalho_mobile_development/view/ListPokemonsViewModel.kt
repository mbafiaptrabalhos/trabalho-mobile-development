package br.com.fiap.trabalho_mobile_development.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.trabalho_mobile_development.model.Pokemon
import br.com.fiap.trabalho_mobile_development.repository.PokemonRepository

class ListPokemonsViewModel (
    val pokemonRepository: PokemonRepository
) : ViewModel() {

    val pokemons: MutableLiveData<List<Pokemon>> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val messageError: MutableLiveData<String> = MutableLiveData()

    fun getPokemons() {
        isLoading.value = true;
        pokemonRepository
            .getPokemons(0,
                150,
                onComplete = {
                    pokemons.value = it
                    isLoading.value = false
                    messageError.value = ""
                },
                onError = {
                    pokemons.value = emptyList()
                    isLoading.value = false
                    messageError.value = it?.message
                }
            )
    }
}