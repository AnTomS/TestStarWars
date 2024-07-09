package com.atom.teststarwars.presentation.ui.films

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atom.teststarwars.databinding.CardviewForFilmsBinding
import com.atom.teststarwars.domain.models.films.Result

class FilmsAdapter() : RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder>() {

    private var items: List<Result> = listOf()


    fun setItems(items: List<Result>) {
        this.items = items
        notifyDataSetChanged()
    }

    class FilmsViewHolder(val binding: CardviewForFilmsBinding) :
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
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardviewForFilmsBinding.inflate(inflater, parent, false)
        return FilmsViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {

        holder.bind(items[position])
    }
}


