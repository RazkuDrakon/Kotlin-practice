package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.monkeyfilm.loginScreen
import screens.favScreen
import screens.homeScreen
import screens.profileScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.loginScreen.route){
        composable(route = AppScreens.loginScreen.route){
            loginScreen(navController)
        }
        composable(route = AppScreens.homeScreen.route){
            homeScreen(navController)
        }
        composable(route = AppScreens.favScreen.route){
            favScreen(navController)
        }
        composable(route = AppScreens.profileScreen.route){
            profileScreen(navController)
        }
    }
}