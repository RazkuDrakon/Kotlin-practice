package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.monkeyfilm.R
import navigation.AppScreens

@Composable
fun favScreen(navController : NavController){
    var bottomState by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("MonkeyFilms") },backgroundColor = colorResource(id = R.color.purple_dark),contentColor = Color.White, navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Menu, "Menu")
                }
            }, actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.Add , contentDescription = "Add" )
                }
            })
        },
        content = {
                  Column(horizontalAlignment = Alignment.CenterHorizontally) {
                      Row(Modifier.padding(8.dp)) {
                          SurfCard()
                      }
                  }
        },
        floatingActionButton = {},
        bottomBar = {
            BottomNavigation(backgroundColor = colorResource(id = R.color.purple_dark), contentColor = Color.White) {

                BottomNavigationItem(
                    selected = bottomState == "Home",
                    onClick = { navController.navigate(route = AppScreens.homeScreen.route) },
                    label = { Text(text = "Home",color = Color.White) },
                    icon = { Icon(imageVector = Icons.Default.Home , contentDescription = null) }
                )

                BottomNavigationItem(
                    selected = bottomState == "Favorite",
                    onClick = { navController.navigate(route = AppScreens.favScreen.route) },
                    label = { Text(text = "Favorite",color = Color.White) },
                    icon = { Icon(imageVector = Icons.Default.Favorite , contentDescription = null) }
                )

                BottomNavigationItem(
                    selected = bottomState == "Person",
                    onClick = { navController.navigate(route = AppScreens.profileScreen.route) },
                    label = { Text(text = "Profile",color = Color.White) },
                    icon = { Icon(imageVector = Icons.Default.Person , contentDescription = null) }
                )
            }
        }
    )
}

@Composable
fun SurfCard(){
    Card(){
        Image(
            painter = painterResource(id = R.drawable.surf),
            contentDescription = null,
            modifier= Modifier
                .padding(10.dp)
                .clip(CircleShape)
                .border(0.dp, Color.White, CircleShape)
                .size(70.dp)
        )
        Text(
            text= "Train to Busan",
            modifier = Modifier.padding(100.dp, 15.dp)
        )

        Icon(
            imageVector= Icons.Default.Star,
            contentDescription= null,
            tint= Color.DarkGray,
            modifier = Modifier.padding(100.dp, 35.dp)
        )
        Text(
            text= "9",
            modifier = Modifier.padding(125.dp, 35.dp)
        )

        Icon(
            imageVector= Icons.Default.Delete,
            contentDescription= null,
            tint= Color.Red,
            modifier= Modifier
                .padding(start = 280.dp, top = 30.dp)
        )
    }
}