package com.atom.teststarwars.presentation.ui.planets

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atom.teststarwars.databinding.CardviewForPlanetsBinding
import com.atom.teststarwars.domain.models.planet.Planet

class PlanetsAdapter() :
    ListAdapter<Planet, PlanetsAdapter.PlanetViewHolder>(PlanetDiffUtilCallback()) {
    class PlanetViewHolder(private val binding: CardviewForPlanetsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(planet: Planet) {
            binding.apply {
                fieldNamePlanet.text = planet.name
                fieldClimate.text = planet.climate
                fieldTerrain.text = planet.terrain
                fieldGravity.text = planet.gravity
                fieldPopulation.text = planet.population
                fieldClimate.text = planet.climate
            }
        }
    }

    class PlanetDiffUtilCallback : DiffUtil.ItemCallback<Planet>() {
        override fun areItemsTheSame(oldItem: Planet, newItem: Planet): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Planet, newItem: Planet): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlanetsAdapter.PlanetViewHolder {
        val binding =
            CardviewForPlanetsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return PlanetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlanetsAdapter.PlanetViewHolder, position: Int) {
        val planet = getItem(position)
        holder.bind(planet)
    }

}