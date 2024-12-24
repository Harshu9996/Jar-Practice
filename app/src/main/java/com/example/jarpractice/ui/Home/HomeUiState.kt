package com.example.jarpractice.ui.Home

import com.example.jarpractice.domain.model.Person

data class HomeUiState(
    val isLoading:Boolean = false,
    val isSuccess:Boolean = false,
    val isFailure:Boolean = false,
    val errorMessage:String? = null,
    val persons:List<Person>? = null
)