package com.mousbai.cryptotracker.presentation.api


import retrofit2.Call
import retrofit2.http.GET

interface CryptoApi {
    @GET("?data=meta&key=skv6e856h4hbkncs0msxo&type=full")
    fun getCryptoList(): Call<CryptoListResponse>

    @GET("?data=meta&key=skv6e856h4hbkncs0msxo&type=full")
    fun getCryptoDetail(): Call<CryptoDetailResponse>

}