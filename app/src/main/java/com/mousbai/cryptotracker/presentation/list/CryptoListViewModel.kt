package com.mousbai.cryptotracker.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mousbai.cryptotracker.presentation.Singletons
import com.mousbai.cryptotracker.presentation.api.CryptoListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CryptoListViewModel : ViewModel(){
    val cryptoList: MutableLiveData<List<Crypto>> = MutableLiveData()

    init{
        callApi()
    }

    private fun callApi() {
        Singletons.cryptoApi.getCryptoList().enqueue(object: Callback<CryptoListResponse> {
            override fun onFailure(call: Call<CryptoListResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<CryptoListResponse>, response: Response<CryptoListResponse>
            ) {
                if(response.isSuccessful && response.body() != null){
                    val cryptoResponse = response.body()!!
                    val dataSorted = cryptoResponse.data.take(100)
                    cryptoList.value = dataSorted

                }
            }

        })
    }
}