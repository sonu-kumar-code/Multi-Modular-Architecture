package com.app.composemultimodule.onbarding.compose.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.composemultimodule.common.navigation.ScreenGraph
import com.app.composemultimodule.onbarding.compose.LoginScreen
import com.app.composemultimodule.onbarding.compose.navigation.OnboardingScreens

fun NavGraphBuilder.addOnboardingGraph(
    navController: NavHostController,
){
    val rootScreen = OnboardingScreens
    navigation(route = rootScreen.route, startDestination = rootScreen.createRoute(OnboardingScreens.Login)){
        LoginDestination(
            navController = navController,
            rootScreen = rootScreen
        )
    }
}

internal fun NavGraphBuilder.LoginDestination(
    navController: NavHostController,
    rootScreen:ScreenGraph
){
    composable(
        route = rootScreen.createRoute(OnboardingScreens.Login)
    ){
        LoginScreen()
    }
}