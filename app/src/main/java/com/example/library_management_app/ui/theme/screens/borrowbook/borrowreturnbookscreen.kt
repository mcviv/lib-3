package com.example.library_management_app.ui.theme.screens.borrowbook

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.library_management_app.data.BookViewModel
import com.example.library_management_app.models.Book
import com.google.firebase.database.FirebaseDatabase


@Composable
fun BorrowedBook(navController: NavController){
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) {}
    launcher.toString()
    val context = LocalContext.current
    var productRepository = BookViewModel(navController,context)


    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }

    val currentDataRef = FirebaseDatabase.getInstance().getReference()
        .child("Book/$title$author")
    currentDataRef.database.getReference(title)



    val emptyUploadState = remember { mutableStateOf(Book("", "")) }
    var emptyUploadsListState = remember { mutableStateListOf<Book>() }

    var book = productRepository.BookList(emptyUploadState, emptyUploadsListState)
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "BookReturn",
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn() {
            items(book) {
                Bookstaff(
                    navController = navController,
                    productRepository= productRepository,
                    title = it.title,
                    author = it.author)

            }
        }
    }
}


@Composable
fun Bookstaff(
    navController: NavController,
    productRepository: BookViewModel,
    title: String,
    author: String
) {
    val showFullText by remember {
        mutableStateOf(false)
    }
    showFullText.toString()
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxWidth(),) {
        Card(
            modifier = Modifier
                .padding(10.dp)
                .height(210.dp)
                .animateContentSize(),
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(
                containerColor = Color.Gray
            )
        ) {
            Row() {
                Column(
                    modifier = Modifier
                        .padding(vertical = 20.dp, horizontal = 15.dp)
                        .verticalScroll(
                            rememberScrollState()


                        )
                ) {
                    Text(
                        text = "Author",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = author,
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Title",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = title,
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )

                }
                Spacer(modifier = Modifier.width(5.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {

                    Row {
                        Button(
                            onClick = {
                                productRepository.returnBook(context ,navController, title, author)


                            },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(Color.Black)
                        ) {
                            Text(
                                text = "Return",
                                color = Color.Blue,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                        }
                        Spacer(modifier = Modifier.width(5.dp))

                    }
                }


            }

        }
    }
}

