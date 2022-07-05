package zw.co.gosave.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import zw.co.gosave.ui.screens.Home
import zw.co.gosave.ui.screens.Login


@Composable
fun MyNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable(route = "home"){
            Home(navController)
        }
        composable(route = "login"){
            Login(navController)
        }
    }
}
