package com.mousbai.cryptotracker.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mousbai.cryptotracker.R
import com.mousbai.cryptotracker.presentation.Singletons
import com.mousbai.cryptotracker.presentation.detail.CryptoDetail
import com.mousbai.cryptotracker.presentation.api.CryptoDetailResponse
import com.mousbai.cryptotracker.presentation.list.CryptoAdapter
import com.mousbai.cryptotracker.presentation.list.CryptoListViewModel
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CryptoDetailFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = CryptoAdapterDetail(listOf())

    private val viewModel: CryptoDetailViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crypto_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.crypto_detail_recyclerview)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@CryptoDetailFragment.adapter
        }

        viewModel.cryptoList.observe(viewLifecycleOwner, Observer {list ->
            adapter.updateList(list)

        })

    }


}