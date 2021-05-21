package com.mousbai.cryptotracker.presentation.api


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {
    @GET("coins/markets?vs_currency=eur&order=market_cap_desc&per_page=50&page=1&sparkline=false")
    fun getCryptoList(): Call<List<CryptoResponse>>

}