package screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.monkeyfilm.R
import navigation.AppScreens

@Composable
fun profileScreen(navController : NavController){
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
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.verticalScroll(
                rememberScrollState())) {
                Row( modifier = Modifier.padding(8.dp)) {
                    TextFieldUser()
                }
                Row (modifier = Modifier.padding(8.dp)){
                    TextFieldEmail()
                }
                Row (modifier = Modifier.padding(8.dp)){
                    TextFieldPass()
                }
                Row (modifier = Modifier.padding(8.dp)){
                    TextFieldPassAgain()
                }
                Row {
                    Text(
                        text = "Intereses",
                        Modifier.padding(12.dp)
                    )
                }
                Row(horizontalArrangement = Arrangement.Start){
                    Box(){
                        var state by rememberSaveable{ mutableStateOf(false) }
                        Checkbox(checked = state, onCheckedChange = {state = !state})
                        Spacer(modifier= Modifier.width(8.dp))
                        Text(
                            text= "Deportes",
                            modifier= Modifier.padding(40.dp, 15.dp, 0.dp, 0.dp)
                        )
                    }

                    Spacer(modifier= Modifier.width(48.dp))

                    Box(Modifier.padding(start= 12.dp)){
                        var state by rememberSaveable{ mutableStateOf(false) }
                        Checkbox(checked = state, onCheckedChange = {state = !state})
                        Spacer(modifier= Modifier.width(8.dp))
                        Text(
                            text= "Romance",
                            modifier= Modifier.padding(40.dp, 15.dp)
                        )
                    }
                }
                Row(horizontalArrangement = Arrangement.Start){
                    Box(){
                        var state by rememberSaveable{ mutableStateOf(false) }
                        Checkbox(checked = state, onCheckedChange = {state = !state})
                        Spacer(modifier= Modifier.width(8.dp))
                        Text(
                            text= "Acción",
                            modifier= Modifier.padding(40.dp, 15.dp, 0.dp, 0.dp)
                        )
                    }

                    Spacer(modifier= Modifier.width(48.dp))

                    Box(Modifier.padding(start= 36.dp)){
                        var state by rememberSaveable{ mutableStateOf(false) }
                        Checkbox(checked = state, onCheckedChange = {state = !state})
                        Spacer(modifier= Modifier.width(8.dp))
                        Text(
                            text= "Históricas",
                            modifier= Modifier.padding(40.dp, 15.dp)
                        )
                    }
                }
                Row(horizontalArrangement = Arrangement.Start){
                    Box(){
                        var state by rememberSaveable{ mutableStateOf(false) }
                        Checkbox(checked = state, onCheckedChange = {state = !state})
                        Spacer(modifier= Modifier.width(8.dp))
                        Text(
                            text= "Si-Fi",
                            modifier= Modifier.padding(40.dp, 15.dp, 0.dp, 0.dp)
                        )
                    }

                    Spacer(modifier= Modifier.width(48.dp))

                    Box(Modifier.padding(start= 24.dp)){
                        var state by rememberSaveable{ mutableStateOf(false) }
                        Checkbox(checked = state, onCheckedChange = {state = !state})
                        Spacer(modifier= Modifier.width(8.dp))
                        Text(
                            text= "Documentales",
                            modifier= Modifier.padding(40.dp, 15.dp)
                        )
                    }
                }
                Row(Modifier.padding(start = 8.dp, bottom = 80.dp, end=8.dp)) {
                    Button(onClick = {  },
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.purple_dark)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)) {
                        Text(text = "Registrarse", color = Color.White)
                    }
                }
            }
        },
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
fun TextFieldUser() {
    var name by remember {
        mutableStateOf("")
    }
    val counterMaxLength = 50 //1

    Column {
        TextField(
            value = name,
            onValueChange = {
                if (it.length <= counterMaxLength) //2
                    name = it
            },
            label = { Text("Usuario") },
            colors= TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor= colorResource(id = R.color.purple_dark),
                unfocusedBorderColor = colorResource(id = R.color.purple_dark)),
        )
        Text(
            text = "${name.length}/$counterMaxLength",//3
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.End) //4
        )
    }
}

@Composable
fun TextFieldEmail() {
    var name by remember {
        mutableStateOf("")
    }
    val counterMaxLength = 50 //1

    Column {
        TextField(
            value = name,
            onValueChange = {
                if (it.length <= counterMaxLength) //2
                    name = it
            },
            label = { Text("Email") },
            colors= TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor= colorResource(id = R.color.purple_dark),
                unfocusedBorderColor = colorResource(id = R.color.purple_dark)),

            )
        Text(
            text = "${name.length}/$counterMaxLength",//3
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.End) //4
        )
    }
}

@Composable
fun Spacer(modifier: Modifier) {
    Layout({}, modifier) { _, constraints ->
        with(constraints) {
            val width = if (hasFixedWidth) maxWidth else 0
            val height = if (hasFixedHeight) maxHeight else 0
            layout(width, height) {}
        }
    }
}

@Composable
fun TextFieldPassword(){
    var texto by remember { mutableStateOf("") }
    var max= 50
    TextField(
        value = texto,
        onValueChange = {
            if(it.length <= max){
                texto = it
            }
        },
        label= { Text(text= "Contraseña") },
        colors= TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor= colorResource(id = R.color.purple_dark),
            unfocusedBorderColor = colorResource(id = R.color.purple_dark)
        ),
        visualTransformation= PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType= KeyboardType.Password)
    )
}

@Composable
fun TextFieldPass() {
    var name by remember {
        mutableStateOf("")
    }
    val counterMaxLength = 50 //1

    Column {
        TextField(
            value = name,
            onValueChange = {
                if (it.length <= counterMaxLength) //2
                    name = it
            },
            label = { Text("Contraseña") },
            colors= TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor= colorResource(id = R.color.purple_dark),
                unfocusedBorderColor = colorResource(id = R.color.purple_dark)),
            visualTransformation= PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType= KeyboardType.Password)

        )
        Text(
            text = "${name.length}/$counterMaxLength",//3
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.End) //4
        )
    }
}

@Composable
fun TextFieldPassAgain() {
    var name by remember {
        mutableStateOf("")
    }
    val counterMaxLength = 50 //1

    Column {
        TextField(
            value = name,
            onValueChange = {
                if (it.length <= counterMaxLength) //2
                    name = it
            },
            label = { Text("Repite la contraseña") },
            colors= TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor= colorResource(id = R.color.purple_dark),
                unfocusedBorderColor = colorResource(id = R.color.purple_dark)),
            visualTransformation= PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType= KeyboardType.Password)

        )
        Text(
            text = "${name.length}/$counterMaxLength",//3
            color = MaterialTheme.colors.onSurface.copy(alpha = ContentAlpha.medium),
            style = MaterialTheme.typography.caption,
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.End) //4
        )
    }
}