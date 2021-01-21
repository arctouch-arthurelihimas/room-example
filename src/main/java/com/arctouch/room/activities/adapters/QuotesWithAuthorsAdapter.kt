package com.arctouch.room.activities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arctouch.room.R
import com.arctouch.room.databinding.QuoteWithAuthorRowBinding
import com.arctouch.room.model.QuoteWithAuthor

typealias DeleteQuoteCallback = (QuoteWithAuthor) -> Unit

class QuotesWithAuthorsAdapter(val deleteCallback: DeleteQuoteCallback) :
    RecyclerView.Adapter<QuotesWithAuthorsAdapter.QuoteWithAuthorHolder>() {

    class QuoteWithAuthorHolder(root: View, val binding: QuoteWithAuthorRowBinding) :
        RecyclerView.ViewHolder(root)

    private var quotes = listOf<QuoteWithAuthor>()

    fun updateItems(newItems: List<QuoteWithAuthor>) {
        quotes = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteWithAuthorHolder {
        val row = LayoutInflater.from(parent.context)
            .inflate(R.layout.quote_with_author_row, parent, false)
        val binding = QuoteWithAuthorRowBinding.bind(row)
        binding.btDelete.setOnClickListener {
            val tag = row.tag as QuoteWithAuthor
            deleteCallback(tag)
        }

        return QuoteWithAuthorHolder(row, binding)
    }

    override fun onBindViewHolder(quoteholder: QuoteWithAuthorHolder, position: Int) {
        val quoteWithAuthor = quotes[position]
        val quoteText = "${quoteWithAuthor.quote.text} - ${quoteWithAuthor.author.name}"

        quoteholder.binding.tvQuote.text = quoteText
        quoteholder.itemView.tag = quoteWithAuthor
    }

    override fun getItemCount() = quotes.size

}