package com.rikihikmianto.covid_19.model

data class IndonesiaResponse (
    val name: String,
    val positif: String,
    val sembuh: String,
    val dirawat: String,
    val meninggal: String
)