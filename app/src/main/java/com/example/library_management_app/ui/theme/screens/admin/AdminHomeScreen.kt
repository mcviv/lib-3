package com.example.library_management_app.ui.theme.screens.admin




import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.library_management_app.navigation.ROUTE_ABOUT
import com.example.library_management_app.navigation.ROUTE_ADD_BOOK
import com.example.library_management_app.navigation.ROUTE_BOOK_LIST
import com.example.library_management_app.navigation.ROUTE_UPDATE_BOOKS


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminHome(navController: NavController) {
    TopAppBar(
        title = { Text(text = "Library") },
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Menu,
                    contentDescription = "Menu")
            }


            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = Color.Black,
            navigationIconContentColor = Color.Black
        ),
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Home,
                    contentDescription = "My Profile")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Build,
                    contentDescription = "My Profile")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Settings,
                    contentDescription = "Search")
            }


        }
    )
    Row (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),

        verticalAlignment = Alignment.CenterVertically,

        ){

        Column (
            modifier = Modifier
                .wrapContentWidth()
                .fillMaxSize()
                .padding(top = 45.dp)
                .width(1000.dp)
        ){
            Card (
                modifier = Modifier
                    .padding(10.dp)

                    .clickable {
                        ROUTE_ADD_BOOK

                    },
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ){
                Box (
                    modifier = Modifier
                        .height(150.dp)
                        .width(500.dp)
                        .clickable { navController.navigate(ROUTE_ADD_BOOK) }

                ){

                    Box (
                        modifier = Modifier
                            .matchParentSize()
                            .padding(27.dp)
                        ,
                        contentAlignment = Alignment.Center
                    ){
                        Text(color = Color.Blue,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            text = "ADD BOOK")
                    }
                }

            }

            Card (
                modifier = Modifier
                    .padding(10.dp)
                    .clickable { navController.navigate(ROUTE_UPDATE_BOOKS)},
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ){
                Box (
                    modifier = Modifier
                        .height(150.dp)
                        .width(500.dp)
                ){

                    Box (
                        modifier = Modifier
                            .matchParentSize()
                            .padding(27.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Text(color = Color.Blue,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            text = "UPDATE BOOK")
                    }
                }


            }
            Card (
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                        navController.navigate(ROUTE_BOOK_LIST)
                    },
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ){
                Box (
                    modifier = Modifier
                        .height(150.dp)
                        .width(500.dp)
                ){

                    Box (
                        modifier = Modifier
                            .matchParentSize()
                            .padding(27.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Text(color = Color.Blue,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            text = "BOOK LIST")
                    }
                }

            }
            Card (
                modifier = Modifier
                    .padding(10.dp)
                    .clickable {
                       navController.navigate(ROUTE_ABOUT)
                    },
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ){
                Box (
                    modifier = Modifier
                        .height(150.dp)
                        .width(500.dp)
                ){


                    Box (
                        modifier = Modifier
                            .matchParentSize()
                            .padding(27.dp),
                        contentAlignment = Alignment.Center
                    ){
                        Text(color = Color.Blue,
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            text = "ABOUT LIBRARY")
                    }
                }

            }
        }

    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AdminHomePreview(){
    AdminHome(rememberNavController())
}