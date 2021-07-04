package br.com.fiap.trabalho_mobile_development.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PokemonNameUrlModel(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
) : Parcelable