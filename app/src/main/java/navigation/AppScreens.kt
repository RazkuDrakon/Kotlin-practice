package navigation

sealed class AppScreens(val route: String){
    object loginScreen: AppScreens("login_screen")
    object homeScreen: AppScreens("home_screen")
    object favScreen: AppScreens("fav_screen")
    object profileScreen: AppScreens("profile_screen")
}
