package com.example.loginui

sealed class Screen(val route: String){
    object SignInScreen: Screen("signIn_screen")
    object SignUpScreen: Screen("signUp_screen")
}
