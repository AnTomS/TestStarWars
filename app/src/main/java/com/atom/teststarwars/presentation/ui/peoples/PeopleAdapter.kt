package com.atom.teststarwars.presentation.ui.peoples

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atom.teststarwars.databinding.CardviewForPeopleBinding
import com.atom.teststarwars.domain.models.people.People


class PeopleAdapter() :
    ListAdapter<People, PeopleAdapter.PeopleViewHolder>(PeopleDiffUtilCallback()) {

    var onPeopleClickListener: ((People) -> Unit)? = null

    class PeopleViewHolder(private val binding: CardviewForPeopleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(people: People) {
            binding.apply {
                fieldNamePeople.text = people.name
                fieldGender.text = people.gender
                fieldDateBirthYear.text = people.birthYear

            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): PeopleAdapter.PeopleViewHolder {
        val binding =
            CardviewForPeopleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return PeopleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeopleAdapter.PeopleViewHolder, position: Int) {
        val people = getItem(position)
        holder.bind(people)
        holder.itemView.setOnClickListener {
            onPeopleClickListener?.invoke(people)
        }
    }
}

class PeopleDiffUtilCallback : DiffUtil.ItemCallback<People>() {
    override fun areItemsTheSame(oldItem: People, newItem: People): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: People, newItem: People): Boolean {
        return oldItem == newItem
    }


}
