package com.example.jarpractice.ui.Util

sealed class Screens(val route:String) {
    object HomeScreen:Screens(route = "home_screen")
    object ProfileScreen:Screens(route = "profile_screen")
}