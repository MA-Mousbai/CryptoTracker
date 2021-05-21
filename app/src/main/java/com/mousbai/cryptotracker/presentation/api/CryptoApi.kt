package com.mousbai.cryptotracker.presentation.api


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {
    @GET("?data=meta&key=skv6e856h4hbkncs0msxo&type=price")
    fun getCryptoList(): Call<CryptoResponse>

}