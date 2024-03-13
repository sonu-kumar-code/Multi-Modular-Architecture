package com.app.composemultimodule.onboarding.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.app.composemultimodule.onboarding.state.LoginViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    onClick:()->Unit
){
    print("sonu kumar "+viewModel)
    Column {
        Text(text = "Hello", modifier = Modifier.clickable {
            onClick()
        })
    }
}