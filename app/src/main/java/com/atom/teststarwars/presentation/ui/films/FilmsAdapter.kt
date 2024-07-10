package com.atom.teststarwars.presentation.ui.films

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atom.teststarwars.databinding.CardviewForFilmsBinding
import com.atom.teststarwars.domain.models.films.Result

class FilmsAdapter() : RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder>() {

    private var items: List<Result> = listOf()


    fun setItems(items: List<Result>) {
        Log.d("FilmsAdapter", "Set items: $items")
        this.items = items
        notifyDataSetChanged()
    }

    class FilmsViewHolder(private val binding: CardviewForFilmsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Result) {
            binding.apply {
                fieldTitleFilm.text = item.title
                fieldDirectorFilm.text = item.director
                fieldProducerFilm.text = item.producer
                fieldReleaseDateFilm.text = item.releaseDate
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        val binding = CardviewForFilmsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return FilmsViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.bind(items[position])
    }
}


