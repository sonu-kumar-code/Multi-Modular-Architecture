package com.app.composemultimodule.onboarding.compose.navigation.graph

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.composemultimodule.common.navigation.ScreenGraph
import com.app.composemultimodule.onboarding.compose.LoginScreen
import com.app.composemultimodule.onboarding.compose.RegistrationScreen
import com.app.composemultimodule.onboarding.compose.navigation.OnboardingScreens
import com.app.composemultimodule.onboarding.state.LoginViewModel

fun NavGraphBuilder.addOnboardingGraph(
    navController: NavHostController,
){
    val rootScreen = OnboardingScreens
    navigation(route = rootScreen.route, startDestination = rootScreen.createRoute(OnboardingScreens.Login)){
        LoginDestination(
            navController = navController,
            rootScreen = rootScreen
        )
        RegistrationDestination(
            navController = navController,
            rootScreen = rootScreen
        )
    }
}

internal fun NavGraphBuilder.LoginDestination(
    navController: NavHostController,
    rootScreen: ScreenGraph
){
    composable(
        route = rootScreen.createRoute(OnboardingScreens.Login)
    ){
        val vm = hiltViewModel<LoginViewModel>()
        LoginScreen(
            vm,
            onClick = {
                navController.navigate(rootScreen.createRoute(OnboardingScreens.Registration))
            }
        )
    }
}

internal fun NavGraphBuilder.RegistrationDestination(
    navController: NavHostController,
    rootScreen: ScreenGraph
){
    composable(
        route = rootScreen.createRoute(OnboardingScreens.Registration)
    ){
        RegistrationScreen(
        )
    }
}