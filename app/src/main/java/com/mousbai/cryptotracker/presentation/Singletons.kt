package com.mousbai.cryptotracker.presentation

import com.mousbai.cryptotracker.presentation.CryptoApplication.Companion.context
import com.mousbai.cryptotracker.presentation.api.CryptoApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singletons{
    companion object {
        var cache: Cache = Cache(File(context?.cacheDir, "responses"), 10*1024*1024)

        val okhttpClient: OkHttpClient = OkHttpClient().newBuilder()
                .cache(cache)
                .build()

        val cryptoApi: CryptoApi = Retrofit.Builder()
                .baseUrl("https://api.lunarcrush.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient)
                .build()
                .create(CryptoApi::class.java)


    }
}
