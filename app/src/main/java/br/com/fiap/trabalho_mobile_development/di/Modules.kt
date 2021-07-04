package br.com.fiap.trabalho_mobile_development.di

import android.content.Context
import br.com.fiap.trabalho_mobile_development.api.PokemonService
import br.com.fiap.trabalho_mobile_development.repository.PokemonRepository
import br.com.fiap.trabalho_mobile_development.repository.PokemonRepositoryImpl
import br.com.fiap.trabalho_mobile_development.view.form.FormPokemonViewModel
import br.com.fiap.trabalho_mobile_development.view.list.ListPokemonsViewModel
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val viewModelModule = module {
    viewModel {
        ListPokemonsViewModel(
            get()
        )}
        viewModel { FormPokemonViewModel(get()) }

}

val repositoryModule = module {
    single<PokemonRepository> { PokemonRepositoryImpl(get()) }
}

val networkModule = module {
    single { createNetworkClient(get()).create(PokemonService::class.java) }
    single { createOkhttpClientAuth() }
    single { createPicassoAuth(get(), get()) }
}

private fun createPicassoAuth(
    context: Context,
    okHttpClient: OkHttpClient
): Picasso {
    return Picasso
        .Builder(context)
        .downloader(OkHttp3Downloader(okHttpClient))
        .build()
}

private fun createNetworkClient(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://pokeapi.co")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun createOkhttpClientAuth(): OkHttpClient {
    val builder = OkHttpClient.Builder()
        .addNetworkInterceptor(StethoInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
    return builder.build()
}
