package com.mousbai.cryptotracker.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mousbai.cryptotracker.R
import com.mousbai.cryptotracker.presentation.api.CryptoApi
import com.mousbai.cryptotracker.presentation.api.CryptoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CryptoListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = CryptoAdapter(listOf(), ::onClickedCrypto)

    private fun onClickedCrypto(crypto: Crypto) {
        findNavController().navigate(R.id.navigateToCryptoDetailFragment)
    }

    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crypto_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.crypto_recyclerview)


        recyclerView.apply {
            layoutManager = this@CryptoListFragment.layoutManager
            adapter = this@CryptoListFragment.adapter
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.lunarcrush.com/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val cryptoApi: CryptoApi = retrofit.create(CryptoApi::class.java)

        cryptoApi.getCryptoList().enqueue(object: Callback<CryptoResponse>{
            override fun onFailure(call: Call<CryptoResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call<CryptoResponse>, response: Response<CryptoResponse>
            ) {
               if(response.isSuccessful && response.body() != null){
                   val cryptoResponse = response.body()!!
                   val dataSorted = cryptoResponse.data.take(100)
                   adapter.updateList(dataSorted)
               }
            }

        })




    }
}