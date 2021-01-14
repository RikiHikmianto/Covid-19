package com.rikihikmianto.covid_19.model

import com.google.gson.annotations.SerializedName

data class Provinsi (
    @SerializedName("Kode_Provi")
    val code: Int,
    @SerializedName("Provinsi")
    val provinsi: String,
    @SerializedName("Kasus_Posi")
    val positif: Int,
    @SerializedName("Kasus_Meni")
    val meninggal: Int,
    @SerializedName("Kasus_Semb")
    val sembuh: Int,
        )