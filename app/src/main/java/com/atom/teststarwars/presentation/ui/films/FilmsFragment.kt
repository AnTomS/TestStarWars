package com.atom.teststarwars.presentation.ui.films

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.atom.teststarwars.databinding.FragmentFilmsBinding
import com.atom.teststarwars.presentation.App
import com.atom.teststarwars.presentation.state.LoadingState
import javax.inject.Inject

class FilmsFragment : Fragment() {

    private var _binding: FragmentFilmsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var filmsViewModel: FilmsViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("FilmsFragment", "onAttach")
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

        _binding = FragmentFilmsBinding.inflate(inflater, container, false)

        filmsViewModel.films.observe(viewLifecycleOwner, { state ->
            when (state) {
                is LoadingState.Loading -> {
                    Log.d("FilmsFragment", "Loading films...")
                }
                is LoadingState.Success -> {
                    Log.d("FilmsFragment", "Films loaded: ${state.data}")
                }
                is LoadingState.Error -> {
                    Log.e("FilmsFragment", "Error loading films: ${state.exception}")
                }
            }
        })

        filmsViewModel.getFilmsList()

        return binding.root
    }
}