package com.app.composemultimodule.onboarding.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.composemultimodule.onboarding.state.RegistrationViewModel

@Composable
fun RegistrationScreen(
    viewModel:RegistrationViewModel = hiltViewModel()
) {
    print("sonu kumars "+viewModel)
    Column {
        Text(text = "Registration")
    }
}