package com.example.jarpractice.ui.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jarpractice.common.Result
import com.example.jarpractice.domain.usecases.GetAllPersonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllPersons:GetAllPersonUseCase
):ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        toggleUiState()
    }


    private fun toggleUiState(){
        viewModelScope.launch(Dispatchers.Main) {
            delay(1000)
            _uiState.update {
                it.copy(isLoading = true)
            }
            delay(1000)
            _uiState.update {
                it.copy(isSuccess = true, isLoading = false)
            }
            delay(1000)
            _uiState.update {
                it.copy(isFailure = true, isLoading = false, isSuccess = false)
            }
            delay(1000)

        }
    }

    fun getAllPerson(){
        viewModelScope.launch {
            getAllPersons().flowOn(Dispatchers.IO).collect{personsListResult->

                when(personsListResult){
                    is Result.Failure -> {
                        _uiState.update {
                            it.copy(isLoading = false,isSuccess = false,isFailure = true, errorMessage = personsListResult.message,persons = null)
                        }
                    }
                    is Result.Loading -> {
                        _uiState.update {
                            it.copy(isLoading = true,isSuccess = false,isFailure = false,errorMessage = null,persons = null)
                        }
                    }
                    is Result.Success -> {
                        _uiState.update {
                            it.copy(isLoading = false,isSuccess = true,isFailure = false,errorMessage = null,persons = personsListResult.data)
                        }

                    }
                }

            }
        }
    }




}