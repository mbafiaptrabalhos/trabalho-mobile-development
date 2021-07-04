package br.com.fiap.trabalho_mobile_development.view.form

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import br.com.fiap.trabalho_mobile_development.R
import br.com.fiap.trabalho_mobile_development.model.Pokemon
import br.com.fiap.trabalho_mobile_development.model.PokemonNameUrlModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_form_pokemon.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class FormPokemonActivity : AppCompatActivity() {
    val formPokemonViewModel: FormPokemonViewModel by viewModel()
    val picasso: Picasso by inject()
    lateinit var pokemon: PokemonNameUrlModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_pokemon)
        setValues()
        formPokemonViewModel.messageResponse.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

    }

    private fun setValues() {
        pokemon = intent.getParcelableExtra<PokemonNameUrlModel>("POKEMON")
        val index = intent.getStringExtra("INDEX")
        tvPokemonNameForm.text = pokemon.name
        tvNumber.text = index
        picasso.load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${index}.png").into(ivPokemonForm)
    }

}
