package com.example.library_management_app.ui.theme.screens.option


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.library_management_app.navigation.ROUTE_ADMIN_REGISTER
import com.example.library_management_app.navigation.ROUTE_REGISTER



@Composable
fun Option(navController: NavController) {


    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,




        ) {
        Text(

            text = "SignUp Options",
            fontSize = 30.sp,
            color = Color.Blue,
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Transparent)
                .padding(30.dp)
                .fillMaxWidth()

        )

    }


    Card (
        modifier = Modifier
            .paddingFromBaseline(240.dp)
            .clickable { navController.navigate(ROUTE_ADMIN_REGISTER) },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(10.dp),

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
                    text = "Admin")
            }
        }


    }
    Card (
        modifier = Modifier
            .paddingFromBaseline(440.dp)
            .clickable { navController.navigate(ROUTE_REGISTER) },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(10.dp),

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
                    text = "User")
            }
        }


    }


}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OptionPreview(){
    Option(rememberNavController())
}
