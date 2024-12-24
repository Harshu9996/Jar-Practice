package com.example.jarpractice.ui.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle()


    Scaffold(modifier=Modifier.fillMaxSize()) {padding->
        Column(modifier = Modifier.fillMaxSize().padding(padding)) {
            Text(text = "Loading = "+ uiState.value.isLoading)
            Spacer(Modifier.height(50.dp))
            Text(text = "Success = "+ uiState.value.isSuccess)
            Spacer(Modifier.height(50.dp))
            Text(text = "Error = "+ uiState.value.isFailure)
            Spacer(Modifier.height(50.dp))

        }


    }


}