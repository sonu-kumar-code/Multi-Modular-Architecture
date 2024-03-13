package com.app.composemultimodule.app_navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.app.composemultimodule.onboarding.compose.navigation.OnboardingScreens
import com.app.composemultimodule.onboarding.compose.navigation.graph.addOnboardingGraph

/**
 * @param modifier
 * @param navController
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AppNavigation(
    navController: NavHostController,
){
    NavHost(navController = navController, startDestination = OnboardingScreens.route ){
        addOnboardingGraph(
            navController = navController
        )
    }
}