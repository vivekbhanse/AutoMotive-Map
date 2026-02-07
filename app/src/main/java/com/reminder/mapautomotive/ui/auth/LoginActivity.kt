package com.reminder.mapautomotive.ui.auth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.reminder.mapautomotive.ui.components.LoginPage
import com.reminder.mapautomotive.ui.main.MainActivity
import com.reminder.mapautomotive.ui.main.ui.theme.MapAutomotiveTheme
import com.reminder.mapautomotive.ui.navigation.AppNavGraph
import com.reminder.mapautomotive.ui.navigation.Routes
import com.reminder.mapautomotive.utils.RequestLocationPermission
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: LoginViewModel = koinViewModel()
            val navController = rememberNavController()
            MapAutomotiveTheme {
                AppNavGraph(navController = navController)
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RequestLocationPermission({
                        Timber.d("Permission", "Granted")
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()

                    })
                    LoginPage(
                        viewModel,
                        onSuccess = {
//                            navController.navigate(Routes.HOME) {
//                            popUpTo(Routes.LOGIN) { inclusive = true }
//                        }

                            // Launch MainActivity
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()

                        })

                }
            }
        }
    }
}
