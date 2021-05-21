package com.mousbai.cryptotracker.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mousbai.cryptotracker.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CryptoListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = CryptoAdapter(listOf())
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

        val cryptoList = arrayListOf<Crypto>().apply{
            add(Crypto("Bitcoin"))
            add(Crypto("Etherium"))
            add(Crypto("Dogecoin"))

        }
        adapter.updateList(cryptoList)


    }
}