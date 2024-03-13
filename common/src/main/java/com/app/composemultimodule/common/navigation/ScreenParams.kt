package com.app.composemultimodule.common.navigation

interface ScreenParams {
    fun createRoute(root:ScreenGraph): String
}