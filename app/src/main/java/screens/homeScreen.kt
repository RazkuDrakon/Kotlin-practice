package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.monkeyfilm.R
import navigation.AppScreens

@Composable
fun homeScreen(navController: NavController){
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
            Column(modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Row(Modifier.padding(8.dp)) {
                    PawnCard()
                }
                Row(Modifier.padding(8.dp)) {
                    RatCard()
                }
                Row(Modifier.padding(8.dp)) {
                    KickCard()
                }
                Row(Modifier.padding(8.dp)) {
                    DiveCard()
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
fun PawnCard(){
    Card(){
        Image(
            painter = painterResource(id = R.drawable.patita),
            contentDescription = null,
            modifier= Modifier
                .padding(10.dp)
                .clip(CircleShape)
                .border(0.dp, Color.White, CircleShape)
                .size(70.dp)
        )
        Text(
            text= "Beastars",
            modifier = Modifier.padding(100.dp, 15.dp)
        )

        Icon(
            imageVector= Icons.Default.Star,
            contentDescription= null,
            tint= Color.DarkGray,
            modifier = Modifier.padding(100.dp, 35.dp)
        )
        Text(
            text= "8",
            modifier = Modifier.padding(125.dp, 35.dp)
        )

        Icon(
            imageVector= Icons.Default.AddCircle,
            contentDescription= null,
            tint= Color.Green,
            modifier= Modifier
                .padding(start = 280.dp, top = 24.dp,end = 8.dp)
                .size(36.dp)
        )
    }
}

@Composable
fun RatCard(){
    Card(){
        Image(
            painter = painterResource(id = R.drawable.ratatta),
            contentDescription = null,
            modifier= Modifier
                .padding(10.dp)
                .clip(CircleShape)
                .border(0.dp, Color.White, CircleShape)
                .size(70.dp)
        )
        Text(
            text= "Ratatouille",
            modifier = Modifier.padding(100.dp, 15.dp)
        )

        Icon(
            imageVector= Icons.Default.Star,
            contentDescription= null,
            tint= Color.DarkGray,
            modifier = Modifier.padding(100.dp, 35.dp)
        )
        Text(
            text= "6",
            modifier = Modifier.padding(125.dp, 35.dp)
        )

        Icon(
            imageVector= Icons.Default.AddCircle,
            contentDescription= null,
            tint= Color.Green,
            modifier= Modifier
                .padding(start = 280.dp, top = 24.dp,end = 8.dp)
                .size(36.dp)
        )
    }
}

@Composable
fun DiveCard(){
    Card(){
        Image(
            painter = painterResource(id = R.drawable.buceadoh),
            contentDescription = null,
            modifier= Modifier
                .padding(10.dp)
                .clip(CircleShape)
                .border(0.dp, Color.White, CircleShape)
                .size(70.dp)
        )
        Text(
            text= "Titanic",
            modifier = Modifier.padding(100.dp, 15.dp)
        )

        Icon(
            imageVector= Icons.Default.Star,
            contentDescription= null,
            tint= Color.DarkGray,
            modifier = Modifier.padding(100.dp, 35.dp)
        )
        Text(
            text= "7",
            modifier = Modifier.padding(125.dp, 35.dp)
        )

        Icon(
            imageVector= Icons.Default.AddCircle,
            contentDescription= null,
            tint= Color.Green,
            modifier= Modifier
                .padding(start = 280.dp, top = 24.dp,end = 8.dp)
                .size(36.dp)
        )
    }
}

@Composable
fun KickCard(){
    Card(){
        Image(
            painter = painterResource(id = R.drawable.patada),
            contentDescription = null,
            modifier= Modifier
                .padding(10.dp)
                .clip(CircleShape)
                .border(0.dp, Color.White, CircleShape)
                .size(70.dp)
        )
        Text(
            text= "Cobra Kai",
            modifier = Modifier.padding(100.dp, 15.dp)
        )

        Icon(
            imageVector= Icons.Default.Star,
            contentDescription= null,
            tint= Color.DarkGray,
            modifier = Modifier.padding(100.dp, 35.dp)
        )
        Text(
            text= "7",
            modifier = Modifier.padding(125.dp, 35.dp)
        )

        Icon(
            imageVector= Icons.Default.AddCircle,
            contentDescription= null,
            tint= Color.Green,
            modifier= Modifier
                .padding(start = 280.dp, top = 24.dp, end = 8.dp)
                .size(36.dp)
        )
    }
}