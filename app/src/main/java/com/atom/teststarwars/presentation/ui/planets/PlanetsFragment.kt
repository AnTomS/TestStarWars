package com.atom.teststarwars.presentation.ui.planets

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.atom.teststarwars.databinding.FragmentPlanetsBinding
import com.atom.teststarwars.presentation.App
import com.atom.teststarwars.presentation.state.LoadingState
import javax.inject.Inject

class PlanetsFragment : Fragment() {
    private var _binding: FragmentPlanetsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var planetViewModel: PlanetsViewModel

    private lateinit var planetAdapter: PlanetsAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("PlanetsFragment", "onAttach")
        (requireActivity().application as App).appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val appComponent = (requireActivity().application as App).appComponent
        appComponent.inject(this)

        _binding = FragmentPlanetsBinding.inflate(inflater, container, false)
        setupRecyclerView()

        planetViewModel.planets.observe(viewLifecycleOwner, { state ->
            when (state) {
                is LoadingState.Loading -> {
                    Log.d("FilmsFragment", "Loading films...")
                }

                is LoadingState.Success -> {
                    val planet=state.data
                    Log.d("FilmsFragment", "Films loaded: ${state.data}")
                }

                is LoadingState.Error -> {
                    Log.e("FilmsFragment", "Error loading films: ${state.exception}")
                }
            }
        })

        planetViewModel.getPlanetsList()
        return binding.root
    }


    private fun setupRecyclerView() {

        val rc = binding.peoplesRecyclerView

        planetAdapter = PlanetsAdapter()
        rc.adapter = planetAdapter
        Log.d("FilmsFragment", "RecyclerView setup complete")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}