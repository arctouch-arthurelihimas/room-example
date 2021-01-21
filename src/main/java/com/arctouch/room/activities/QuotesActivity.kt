package com.arctouch.room.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.arctouch.room.activities.adapters.QuotesAdapter
import com.arctouch.room.databinding.ActivityQuoteBinding
import com.arctouch.room.model.Quote
import com.arctouch.room.model.QuotesViewModel
import com.arctouch.room.model.ViewModelFactory

class QuotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuoteBinding

    private val model: QuotesViewModel by viewModels(factoryProducer = { ViewModelFactory(this) })

    private val quotesAdapter = QuotesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBindings()
        initModel()
    }

    private fun initBindings() {
        with(binding.rvQuotes) {
            adapter = quotesAdapter
            val dividerDecoration =
                DividerItemDecoration(this@QuotesActivity, DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerDecoration)
        }

        binding.btAdd.setOnClickListener { addItem() }
    }

    private fun initModel() {
        model.loadQuotes().observe(this) { items ->
            quotesAdapter.updateItems(items)
        }
    }

    private fun addItem() {
        val itemName = binding.etAuthorName.text.toString()
        binding.etAuthorName.setText("")
        val item = Quote(itemName)

        model.addItem(item)
    }
}