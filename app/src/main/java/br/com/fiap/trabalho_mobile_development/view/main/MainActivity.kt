package br.com.fiap.trabalho_mobile_development.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.trabalho_mobile_development.R
import br.com.fiap.trabalho_mobile_development.view.list.ListPokemonsActivity
import br.com.fiap.trabalho_mobile_development.view.sobre.SobreActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btSobre.setOnClickListener {
            startActivity(Intent(this, SobreActivity::class.java))
        }
        btPokemonList.setOnClickListener {
            startActivity(Intent(this, ListPokemonsActivity::class.java))
        }
        btClose.setOnClickListener {
            finish()
        }


    }
}
