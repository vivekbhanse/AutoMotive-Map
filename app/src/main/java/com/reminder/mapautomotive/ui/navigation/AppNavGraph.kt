package com.reminder.mapautomotive.ui.navigation

import android.app.Activity
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

import androidx.navigation.compose.composable
import com.reminder.mapautomotive.ui.auth.LoginViewModel
import com.reminder.mapautomotive.ui.components.LoginPage
import com.reminder.mapautomotive.ui.main.MainActivity
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.LOGIN) {
        composable(Routes.LOGIN) {
            val vm: LoginViewModel = koinViewModel()
//            LoginPage(onLoginClicked = {
//                navController.navigate(Routes.HOME) {
//                    popUpTo(Routes.LOGIN) { inclusive = true }
//                }
//            })
        }
        composable(Routes.HOME) {
            val vm: LoginViewModel = koinViewModel()
            val context = LocalContext.current

//            LoginPage(
//                onLoginClicked = {
//                    // Launch MainActivity
//                    val intent = Intent(context, MainActivity::class.java)
//                    context.startActivity(intent)
//
//                    // Finish the current activity (LoginActivity)
//                    if (context is Activity) {
//                        context.finish()
//                    }
//                }
//            )
        }

    }
}