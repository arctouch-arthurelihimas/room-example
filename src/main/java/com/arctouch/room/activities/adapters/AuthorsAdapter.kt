package com.arctouch.room.activities.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arctouch.room.R
import com.arctouch.room.databinding.AuthorRowBinding
import com.arctouch.room.model.Author

typealias DeleteAuthorCallback = (Author) -> Unit

class AuthorsAdapter(val deleteCallback: DeleteAuthorCallback) :
    RecyclerView.Adapter<AuthorsAdapter.AuthorHolder>() {

    class AuthorHolder(root: View, val binding: AuthorRowBinding) : RecyclerView.ViewHolder(root)

    private var authors = listOf<Author>()

    fun updateItems(newAuthors: List<Author>) {
        authors = newAuthors
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorHolder {
        val row = LayoutInflater.from(parent.context).inflate(R.layout.author_row, parent, false)
        val binding = AuthorRowBinding.bind(row)
        binding.btDelete.setOnClickListener {
            val author = row.tag as Author
            deleteCallback(author)
        }

        return AuthorHolder(row, binding)
    }

    override fun onBindViewHolder(holder: AuthorHolder, position: Int) {
        val author = authors[position]

        holder.binding.tvAuthor.text =
            "${author.name}"
        holder.binding.root.tag = author
    }

    override fun getItemCount() = authors.size

}
