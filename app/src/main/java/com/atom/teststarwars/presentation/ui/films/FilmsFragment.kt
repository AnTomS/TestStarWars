package com.atom.teststarwars.presentation.ui.films

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.atom.teststarwars.databinding.FragmentFilmsBinding
import com.atom.teststarwars.domain.models.films.Kino
import com.atom.teststarwars.presentation.App
import com.atom.teststarwars.presentation.state.LoadingState
import javax.inject.Inject

class FilmsFragment : Fragment() {

    private var _binding: FragmentFilmsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var filmsViewModel: FilmsViewModel

    private lateinit var filmAdapter: FilmsAdapter

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
        _binding = FragmentFilmsBinding.inflate(inflater, container, false)
        Log.d("FilmsFragment", "Binding initialized")

        setupRecyclerView()

        filmsViewModel.films.observe(viewLifecycleOwner) { state ->
            when (state) {
                is LoadingState.Loading -> {
                    Log.d("FilmsFragment", "Loading films...")
                }

                is LoadingState.Success -> {
                    val list = state.data
                    Log.d("FilmsFragment", "Films loaded: $list")
                    filmAdapter.submitList(list)
                }

                is LoadingState.Error -> {
                    Log.e("FilmsFragment", "Error loading films: ${state.exception}")
                }
            }
        }
        filmsViewModel.getFilmsList()
        filmAdapter.onItemClickListener = object : FilmsAdapter.OnItemClickListener {
            override fun onItemClick(film: Kino) {
                Toast.makeText(context, film.title, Toast.LENGTH_SHORT).show()
            }

        }

        return binding.root
    }

    private fun setupRecyclerView() {

        val rc = binding.filmsRecyclerView

        filmAdapter = FilmsAdapter()
        rc.adapter = filmAdapter
        Log.d("FilmsFragment", "RecyclerView setup complete")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}