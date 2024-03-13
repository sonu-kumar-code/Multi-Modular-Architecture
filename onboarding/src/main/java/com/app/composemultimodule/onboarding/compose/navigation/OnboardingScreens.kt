package com.app.composemultimodule.onboarding.compose.navigation

import com.app.composemultimodule.common.navigation.Screen
import com.app.composemultimodule.common.navigation.ScreenGraph
import com.app.composemultimodule.common.navigation.ScreenParams

object OnboardingScreens : ScreenGraph {

    override val route: String
        get() = "onboarding"

    object Login : Screen {
        override val route: String
            get() = "login"

        object Params : ScreenParams {
            override fun createRoute(root: ScreenGraph) = "${root.route}/$route"
        }
    }

    object Registration : Screen {
        override val route: String
            get() = "registration"

        object Params : ScreenParams {
            override fun createRoute(root: ScreenGraph) = "${root.route}/$route"
        }
    }
}