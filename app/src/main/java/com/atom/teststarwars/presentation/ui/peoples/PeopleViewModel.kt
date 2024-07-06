package com.atom.teststarwars.presentation.ui.peoples

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atom.teststarwars.domain.models.people.People
import com.atom.teststarwars.domain.usecase.peopleusecase.GetPeopleListUseCase
import com.atom.teststarwars.presentation.state.LoadingState
import kotlinx.coroutines.launch
import javax.inject.Inject

class PeopleViewModel @Inject constructor(private val getPeopleListUseCase: GetPeopleListUseCase) :
    ViewModel() {

    private val _peopleList = MutableLiveData<LoadingState<List<People>>>()
    val peopleList: LiveData<LoadingState<List<People>>> get() = _peopleList

    fun getPeopleList() {
        viewModelScope.launch {
            _peopleList.value = LoadingState.Loading

            try {
                val requestPeopleList = getPeopleListUseCase()
                _peopleList.value = requestPeopleList
            } catch (e: Exception) {
                _peopleList.value = LoadingState.Error(e.toString())
            }
        }
    }
}