package com.example.library_management_app.navigation



import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.library_management_app.ui.theme.screens.about.About
import com.example.library_management_app.ui.theme.screens.admin.AdminHome
//import com.example.library_management_app.ui.theme.screens.admin.AdminHomeScreens
import com.example.library_management_app.ui.theme.screens.admin.AdminLogin
import com.example.library_management_app.ui.theme.screens.admin.AdminRegister
import com.example.library_management_app.ui.theme.screens.book.AddBook
import com.example.library_management_app.ui.theme.screens.book.BookList
import com.example.library_management_app.ui.theme.screens.book.BookUpdate
import com.example.library_management_app.ui.theme.screens.borrowbook.BorrowedBook
//import com.example.library_management_app.ui.theme.screens.borrowbook.BorrowedBook
import com.example.library_management_app.ui.theme.screens.homescreen.HomeScreens
import com.example.library_management_app.ui.theme.screens.login.Login
import com.example.library_management_app.ui.theme.screens.option.Option
import com.example.library_management_app.ui.theme.screens.register.Register

@Composable
fun AppNavHost(
    navController: NavHostController =rememberNavController(),
    startDestination: String = ROUTE_OPTION){

    NavHost(navController=navController,
        startDestination=startDestination){

        composable(ROUTE_REGISTER){ Register("",navController)}
        composable(ROUTE_HOME){ HomeScreens(navController)}
        composable(ROUTE_LOGIN){ Login(navController)}
        composable(ROUTE_ADD_BOOK){ AddBook(navController)}
        composable(ROUTE_BOOK_LIST){ BookList(navController) }
        composable(ROUTE_ADMIN_HOME){ AdminHome(navController)}
        composable(ROUTE_ADMIN_LOGIN){ AdminLogin(navController)}
        composable(ROUTE_ADMIN_REGISTER){ AdminRegister("",navController)}
        composable(ROUTE_OPTION){ Option(navController) }
        composable(ROUTE_ABOUT){About(navController)}
        composable(ROUTE_BORROWED){ BorrowedBook(navController)}
        composable(ROUTE_UPDATE_BOOKS+"/{id}"){ passedData -> BookUpdate(navController)



        }

    }

}