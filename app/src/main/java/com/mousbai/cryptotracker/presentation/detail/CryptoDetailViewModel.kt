package com.mousbai.cryptotracker.presentation.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mousbai.cryptotracker.presentation.Singletons
import com.mousbai.cryptotracker.presentation.api.CryptoDetailResponse
import com.mousbai.cryptotracker.presentation.list.Crypto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CryptoDetailViewModel : ViewModel(){
    val cryptoList: MutableLiveData<List<CryptoDetail>> = MutableLiveData()
    init {
        callApi()
    }

    private fun callApi() {
        Singletons.cryptoApi.getCryptoDetail().enqueue(object : Callback<CryptoDetailResponse> {
            override fun onFailure(call: Call<CryptoDetailResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<CryptoDetailResponse>, response: Response<CryptoDetailResponse>) {

                if (response.isSuccessful && response.body() != null) {
                    val cryptoResponse = response.body()!!
                    val dataSorted = cryptoResponse.data.take(100)
                    cryptoList.value = dataSorted
                }
            }

        })
    }
}