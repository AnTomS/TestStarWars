package com.atom.teststarwars.presentation.ui.peoples

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.atom.teststarwars.databinding.FragmentPeopleBinding
import com.atom.teststarwars.presentation.App
import com.atom.teststarwars.presentation.state.LoadingState
import javax.inject.Inject

class PeopleFragment : Fragment() {
    private var _binding: FragmentPeopleBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var peopleViewModel: PeopleViewModel

    private lateinit var peopleAdapter: PeopleAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("PeopleFragment", "onAttach")
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

        _binding = FragmentPeopleBinding.inflate(inflater, container, false)

        setupRecyclerView()

        peopleViewModel.peopleList.observe(viewLifecycleOwner, { state ->
            when (state) {
                is LoadingState.Loading -> {
                    Log.d("FilmsFragment", "Loading films...")
                }

                is LoadingState.Success -> {
                    Log.d("FilmsFragment", "Films loaded: ${state.data}")
                    peopleAdapter.submitList(state.data)
                }

                is LoadingState.Error -> {
                    Log.e("FilmsFragment", "Error loading films: ${state.exception}")
                }
            }
        })

        peopleViewModel.getPeopleList()
        return binding.root
    }

    private fun setupRecyclerView() {

        val rc = binding.peoplesRecyclerView

        peopleAdapter = PeopleAdapter()
        rc.adapter = peopleAdapter
        Log.d("FilmsFragment", "RecyclerView setup complete")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}