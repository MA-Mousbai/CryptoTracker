package com.mousbai.cryptotracker.presentation.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mousbai.cryptotracker.R
import com.mousbai.cryptotracker.presentation.list.CryptoAdapter

class CryptoAdapterDetail(private var dataSet: List<CryptoDetail>) :
    RecyclerView.Adapter<CryptoAdapterDetail.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.crypto_detail_name)
            textView.setOnClickListener{

            }
        }
    }

    fun updateList(list: List<CryptoDetail>){
        dataSet = list
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.crypto_detail_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val cryptoD: CryptoDetail = dataSet[position]
        viewHolder.textView.text = cryptoD.short_summary
        viewHolder.itemView.setOnClickListener{
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}