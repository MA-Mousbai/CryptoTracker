package com.mousbai.cryptotracker.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mousbai.cryptotracker.R
import com.mousbai.cryptotracker.presentation.Singletons
import com.mousbai.cryptotracker.presentation.api.CryptoApi
import com.mousbai.cryptotracker.presentation.api.CryptoDetailResponse
import com.mousbai.cryptotracker.presentation.api.CryptoListResponse
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

    private val viewModel: CryptoListViewModel by viewModels()

    private fun onClickedCrypto(crypto: Crypto) {
        findNavController().navigate(R.id.navigateToCryptoDetailFragment)
    }


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
            layoutManager = LinearLayoutManager(context)
            adapter = this@CryptoListFragment.adapter
        }

        viewModel.cryptoList.observe(viewLifecycleOwner, Observer {list ->
            adapter.updateList(list)

        })






    }
}