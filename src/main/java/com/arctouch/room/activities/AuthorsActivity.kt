package com.arctouch.room.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import com.arctouch.room.activities.adapters.AuthorsAdapter
import com.arctouch.room.databinding.ActivityAuthorsBinding
import com.arctouch.room.model.Author
import com.arctouch.room.model.AuthorsViewModel
import com.arctouch.room.model.ViewModelFactory

class AuthorsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthorsBinding

    private val model: AuthorsViewModel by viewModels(factoryProducer = { ViewModelFactory(this) })

    private val authorsAdapter = AuthorsAdapter(::onDeleteAuthorClicked)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAuthorsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBindings()
        initModel()
    }

    private fun initBindings() {
        with(binding.rvQuotes) {
            adapter = authorsAdapter
            val dividerDecoration =
                DividerItemDecoration(this@AuthorsActivity, DividerItemDecoration.VERTICAL)
            addItemDecoration(dividerDecoration)
        }

        binding.btAdd.setOnClickListener { addAuthor() }
    }

    private fun initModel() {
        model.authorsLiveData.observe(this) { items ->
            authorsAdapter.updateItems(items)
        }
        model.load()
    }

    private fun addAuthor() {
        val authorName = binding.etAuthorName.text.toString()
        binding.etAuthorName.setText("")
        val author = Author(name = authorName)

        model.add(author)
    }

    private fun onDeleteAuthorClicked(author: Author) {
        model.delete(author)
    }

}