package br.com.fiap.trabalho_mobile_development.view.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.trabalho_mobile_development.R
import br.com.fiap.trabalho_mobile_development.model.Pokemon
import br.com.fiap.trabalho_mobile_development.model.PokemonNameUrlModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon_list_item.view.*

class ListPokemonsAdapter(
    val pokemons: List<PokemonNameUrlModel>,
    val picasso: Picasso,
    val clickListener: (PokemonNameUrlModel) -> Unit
) : RecyclerView.Adapter<ListPokemonsAdapter.PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.pokemon_list_item, parent, false)
        return PokemonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemons.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = pokemons[position]
        val index = position + 1
        holder.bindView(pokemon, picasso, clickListener, index)
    }

    class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(
            pokemon: PokemonNameUrlModel,
            picasso: Picasso,
            clickListener: (PokemonNameUrlModel) -> Unit,
            index: Int
        ) = with(itemView) {
            tvPokemonNumber.text = index.toString()
            tvPokemonName.text = pokemon.name
            picasso.load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${index}.png").into(ivPokemon)

            setOnClickListener { clickListener(pokemon) }
        }
    }
}