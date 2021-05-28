package com.mousbai.cryptotracker.presentation

import com.mousbai.cryptotracker.presentation.api.CryptoApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Singletons{
    companion object {
        val cryptoApi: CryptoApi = Retrofit.Builder()
                .baseUrl("https://api.lunarcrush.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CryptoApi::class.java)
    }
}
