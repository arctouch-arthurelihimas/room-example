package com.arctouch.room.activities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arctouch.room.R
import com.arctouch.room.databinding.QuoteRowBinding
import com.arctouch.room.model.Quote


class QuotesAdapter :
    RecyclerView.Adapter<QuotesAdapter.QuoteHolder>() {

    class QuoteHolder(root: View, val binding: QuoteRowBinding) : RecyclerView.ViewHolder(root)

    private var quotes = listOf<Quote>()

    fun updateItems(newItems: List<Quote>) {
        quotes = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.quote_row, parent, false)
        val binding = QuoteRowBinding.bind(row)

        return QuoteHolder(row, binding)
    }

    override fun onBindViewHolder(holder: QuoteHolder, position: Int) {
        val quote = quotes[position]

        holder.binding.tvQuote.text = quote.text
    }

    override fun getItemCount() = quotes.size


}
