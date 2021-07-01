package br.com.fiap.trabalho_mobile_development.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    @SerializedName("name") val nome: String,
    @SerializedName("front_default") val frontDefaultImage: String
) : Parcelable