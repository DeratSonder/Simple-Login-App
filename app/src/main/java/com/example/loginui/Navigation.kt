package com.example.loginui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = Screen.SignInScreen.route)
    {
        composable(route = Screen.SignInScreen.route){
            SignIn(navController = navController)
        }
        composable(route = Screen.SignUpScreen.route){
            SignUp(navController = navController)
        }
    }
}