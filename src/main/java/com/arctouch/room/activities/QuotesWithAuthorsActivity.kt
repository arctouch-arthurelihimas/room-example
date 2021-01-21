package com.arctouch.room.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.arctouch.room.activities.adapters.QuotesWithAuthorsAdapter
import com.arctouch.room.databinding.ActivityQuotesWithAuthorsBinding
import com.arctouch.room.model.*

class QuotesWithAuthorsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuotesWithAuthorsBinding

    private val model: QuotesWithAuthorsViewModel
            by viewModels(factoryProducer = { ViewModelFactory(this) })

    private val quotesAdapter = QuotesWithAuthorsAdapter(::onDeleteQuoteClicked)

    private val authorsAdapter by lazy {
        ArrayAdapter<Author>(this, android.R.layout.simple_spinner_dropdown_item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuotesWithAuthorsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        initModel()
    }

    private fun init() {
        with(binding.rvQuotes) {
            adapter = quotesAdapter
            val dividerDecoration =
                DividerItemDecoration(
                    this@QuotesWithAuthorsActivity,
                    DividerItemDecoration.VERTICAL
                )
            addItemDecoration(dividerDecoration)
        }
        binding.spAuthors.adapter = authorsAdapter

        binding.btAdd.setOnClickListener { addQuote() }
    }

    private fun addQuote() {
        val quoteText = binding.etQuote.text.toString()
        val selectedAuthor = binding.spAuthors.selectedItem as Author
        val quote = QuoteV2(text = quoteText, authorId = selectedAuthor.authorId)

        binding.etQuote.setText("")

        model.add(quote)
    }

    private fun initModel() {
        model.quotesLiveData.observe(this) { quotes ->
            quotesAdapter.updateItems(quotes)
        }
        model.authorsLiveData.observe(this) { authors ->
            authorsAdapter.clear()
            authorsAdapter.addAll(authors)
        }
        model.loadAuthorsAndQuotes()
    }

    private fun onDeleteQuoteClicked(quoteWithAuthor: QuoteWithAuthor) {
        model.delete(quoteWithAuthor)
    }

}