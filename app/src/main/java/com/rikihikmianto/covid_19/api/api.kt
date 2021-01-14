package com.rikihikmianto.covid_19.api

import com.rikihikmianto.covid_19.model.IndonesiaResponse
import com.rikihikmianto.covid_19.model.ProvinsiResponse
import retrofit2.Call
import retrofit2.http.GET

interface api {
    @GET("indonesia")
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>

    @GET("indonesia/provinsi")
    fun getProvinsi(): Call<ArrayList<ProvinsiResponse>>

}