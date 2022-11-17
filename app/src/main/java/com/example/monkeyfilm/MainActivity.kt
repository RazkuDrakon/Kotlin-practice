package com.example.monkeyfilm

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.example.monkeyfilm.ui.theme.MonkeyFilmTheme
import navigation.AppNavigation
import navigation.AppScreens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonkeyFilmTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun loginScreen(navController: NavController) {
    var bottomState by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(title = {Text("MonkeyFilms")},backgroundColor = colorResource(id = R.color.purple_dark),contentColor = Color.White, navigationIcon = {
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
                  loginDialog(navController)
        },
        floatingActionButton = {},
        bottomBar = {
            BottomNavigation(backgroundColor = colorResource(id = R.color.purple_dark), contentColor = Color.White) {

                BottomNavigationItem(
                    selected = bottomState == "Home",
                    onClick = { bottomState = "Home" },
                    label = { Text(text = "Home",color = Color.White) },
                    icon = { Icon(imageVector = Icons.Default.Home , contentDescription = null) }
                )

                BottomNavigationItem(
                    selected = bottomState == "Favorite",
                    onClick = { bottomState = "Favorite" },
                    label = { Text(text = "Favorite",color = Color.White) },
                    icon = { Icon(imageVector = Icons.Default.Favorite , contentDescription = null) }
                )

                BottomNavigationItem(
                    selected = bottomState == "Person",
                    onClick = { bottomState = "Person" },
                    label = { Text(text = "Profile",color = Color.White) },
                    icon = { Icon(imageVector = Icons.Default.Person , contentDescription = null) }
                )
            }
        }
    )
}

@Composable
fun loginDialog(navController: NavController){
    Dialog(onDismissRequest = { /*TODO*/ }) {
        var passTxt by remember{ mutableStateOf("") }
        val passTxtR by remember{ mutableStateOf("1234") }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.background(color = Color.White)
        ) {
            Column(modifier = Modifier.padding(12.dp), horizontalAlignment = Alignment.CenterHorizontally) {

                Row(modifier = Modifier.padding(8.dp)) {
                    var text by remember{ mutableStateOf("") }
                    TextField(value = text, onValueChange = {text = it}, label = { Text(text = "Usuario / Email")}, leadingIcon = {
                        Icon(imageVector = Icons.Filled.Person, contentDescription = "user", tint = Color.White, modifier = Modifier
                            .background(color = colorResource(id = R.color.purple_dark))
                            .size(56.dp))
                    })
                }

                Row(modifier = Modifier.padding(8.dp)) {

                    var visiblePass by remember{ mutableStateOf(false) }

                    TextField(value = passTxt,
                        onValueChange = {passTxt = it},
                        label = { Text(text = "Contraseña (Por defecto es '1234')")},
                        trailingIcon = {
                            IconButton(onClick = {visiblePass = !visiblePass}){
                                Icon(painter = painterResource(id = R.drawable.passwordeye), contentDescription = "",
                                    tint = if (visiblePass) colorResource(id = R.color.purple_dark) else Color.Gray)
                            }
                    }, leadingIcon = {
                            Icon(imageVector = Icons.Filled.Lock, contentDescription = "lock", tint = Color.White, modifier = Modifier
                                .background(color = colorResource(id = R.color.purple_dark))
                                .size(56.dp))
                        }
                        , visualTransformation= if (visiblePass) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType= KeyboardType.Password))
                }

                Row(modifier = Modifier.padding(8.dp)){
                    val context = LocalContext.current
                    Button(onClick = {
                        navController.navigate(AppScreens.homeScreen.route)
                                     /*if(passTxt == passTxtR){
                                         Toast.makeText(context,"Login correcto", Toast.LENGTH_SHORT).show()
                                         navController.navigate(AppScreens.homeScreen.route)
                                     }else{
                                         Toast.makeText(context,"Contraseña incorrecta", Toast.LENGTH_SHORT).show()

                                     }*/
                    },
                        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.purple_dark)), modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)) {
                        Text(text = "Entrar", color = Color.White)
                    }
                }
                Row(){
                    Text(text = "¿Aún no te has registrado?", modifier = Modifier.clickable(onClick = {/*TODO*/}), style = TextStyle(textDecoration = TextDecoration.Underline))
                }
            }
        }
    }
}