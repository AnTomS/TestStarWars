package com.atom.teststarwars.presentation.ui.films

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atom.teststarwars.databinding.CardviewForFilmsBinding
import com.atom.teststarwars.domain.models.films.Kino


class FilmsAdapter() : ListAdapter<Kino, FilmsAdapter.FilmsViewHolder>(FilmDiffUtilCallback()) {

    var onItemClickListener: OnItemClickListener? = null

    class FilmsViewHolder(private val binding: CardviewForFilmsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Kino) {
            binding.apply {
                fieldTitleFilm.text = item.title
                fieldDirectorFilm.text = item.director
                fieldProducerFilm.text = item.producer
                fieldReleaseDateFilm.text = item.releaseDate
            }
        }
    }

    class FilmDiffUtilCallback : DiffUtil.ItemCallback<Kino>() {
        override fun areItemsTheSame(oldItem: Kino, newItem: Kino): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Kino, newItem: Kino): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        val binding = CardviewForFilmsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return FilmsViewHolder(binding)
    }


    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        val film = getItem(position)
        holder.bind(film)
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(film)
        }
        Log.d("FilmsAdapter", "Bind item at position $position: ${film.title}")
    }


    interface OnItemClickListener {
        fun onItemClick(film: Kino)
    }
}


