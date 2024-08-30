package com.example.library_management_app.ui.theme.screens.about

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
//import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
//import androidx.compose.runtime.RememberObserver
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.library_management_app.navigation.ROUTE_HOME

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun About(navController: NavController) {
        Column(

            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "Welcome to Library Management",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    color = Color.Red,
                    fontStyle = FontStyle.Italic

                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Our library management app helps you organize," +
                        " catalog, and manage your library efficiently. " +
                        "With a focus on user experience and functionality, " +
                        "our app is designed to streamline your operations, " +
                        "improve book tracking, and enhance user satisfaction." +
                        "",
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Justify,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "This App is design by Markviv thanks to Emobilis Mobile Technology Institute",style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Justify,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic)

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Mission Statement",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif,
                    fontStyle = FontStyle.Italic,
                    color = Color.Red
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Text(
                text = "Our mission is to provide top-notch library management solutions for both small and large institutions, helping you to maintain a well-organized and accessible library for everyone.",
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Justify,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Contact Us",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    color = Color.Red
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            ClickableText(
                text = AnnotatedString("Email: support@librarymanagement.com"),
                style = TextStyle(fontSize = 16.sp, color = Color.Blue),
                onClick = { /* You can add email action here */ }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Phone: +254 706 314 626",
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(100.dp))

            Button(onClick = { navController.navigate(ROUTE_HOME)},
                ) {
                Text(text = "Back")
                
            }
        }

    }



@Preview(showBackground = true)
@Composable
fun PreviewAbout() {
    About(rememberNavController())
}
