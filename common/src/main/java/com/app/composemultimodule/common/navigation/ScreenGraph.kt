package com.app.composemultimodule.common.navigation

interface ScreenGraph {
    val route: String

    fun createRoute(screen:Screen) = "$route/${screen.route}"
}