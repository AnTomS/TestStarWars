package com.atom.teststarwars.presentation.ui.films

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atom.teststarwars.domain.models.films.Kino
import com.atom.teststarwars.domain.usecase.filmsusecase.GetFilmsListUseCase
import com.atom.teststarwars.presentation.state.LoadingState
import kotlinx.coroutines.launch
import javax.inject.Inject

class FilmsViewModel @Inject constructor(private val getFilmsListUseCase: GetFilmsListUseCase) :
    ViewModel() {

    private val _films = MutableLiveData<LoadingState<List<Kino>>>()
    val films: LiveData<LoadingState<List<Kino>>> get() = _films

    fun getFilmsList() {
        viewModelScope.launch {
            _films.value = LoadingState.Loading
            try {
                val requestFilmsList = getFilmsListUseCase()
                _films.value = requestFilmsList
            } catch (e: Exception) {
                _films.value = LoadingState.Error(e.toString())
            }
        }
    }

}