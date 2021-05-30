package com.mousbai.cryptotracker.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mousbai.cryptotracker.R
import java.math.BigDecimal
import java.math.RoundingMode

class CryptoAdapter(private var dataSet: List<Crypto>, var listener: ((Crypto) -> Unit)? = null) :
    RecyclerView.Adapter<CryptoAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView
        val textViewPrice: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.crypto_name)
            textViewPrice = view.findViewById(R.id.crypto_price)
            imageView = view.findViewById(R.id.crypto_image)
        }
    }

    fun updateList(list: List<Crypto>){
        dataSet = list
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.crypto_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val crypto: Crypto = dataSet[position]
        viewHolder.textView.text = crypto.name
        val priceRounded = BigDecimal(crypto.price).setScale(2, RoundingMode.HALF_EVEN)
        viewHolder.textViewPrice.text = "Price: " + priceRounded.toString() + "$"
        viewHolder.itemView.setOnClickListener{
            listener?.invoke(crypto)
        }

       Glide
           .with(viewHolder.itemView.context)
           .load("https://icons.bitbot.tools/api/" + crypto.symbol.toLowerCase() + "/32x32")
           .centerCrop()
           .into(viewHolder.imageView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}