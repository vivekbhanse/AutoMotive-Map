package com.reminder.mapautomotive.ui.components

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.reminder.mapautomotive.ui.auth.LoginViewModel
import kotlinx.coroutines.delay

@Composable
@Preview(showBackground = true)
fun LoginPage(
    viewmodle: LoginViewModel,
    onSuccess: () -> Unit
) {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var submitted by remember { mutableStateOf(false) }
    val uiState = viewmodle.uiState
    val context = LocalContext.current

    // SIDE EFFECTS -------------------------
    LaunchedEffect(submitted) {
        if (submitted && !uiState.isLoading) {

            if (uiState.isSuccess) {
                delay(600)
                onSuccess()
            } else {
                Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
                submitted = false
            }
        }
    }

    // UI -----------------------------------
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF3A2F80),
                        Color(0xFF5B43C0),
                        Color(0xFF9375FF)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        // Login Card
        Card(
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.95f)),
            modifier = Modifier
                .fillMaxWidth(0.90f)

        ) {

            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Animated Title
                AnimatedVisibility(
                    visible = !submitted,
                    enter = fadeIn() + slideInVertically(initialOffsetY = { -80 }),
                ) {
                    Text(
                        text = "Welcome Back!",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            color = Color(0xFF5B43C0),
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                }

                // Username
                OutlinedTextField(
                    value = userName,
                    onValueChange = {
                        viewmodle.onUsernameChange(it)
                        userName = it
                    },
                    label = { Text("Username") },
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(16.dp))

                // Password
                OutlinedTextField(
                    value = password,
                    onValueChange = {
                        viewmodle.onPasswordChange(it)
                        password = it
                    },
                    label = { Text("Password") },
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(Modifier.height(24.dp))

                // Login Button
                Button(
                    onClick = {
                        submitted = true
                        viewmodle.login()
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    enabled = userName.isNotBlank() && password.isNotBlank()
                ) {
                    Text(
                        "Login",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                }

                Spacer(Modifier.height(12.dp))

                // Small text
                Text(
                    "Forgot your password?",
                    color = Color(0xFF5B43C0),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.clickable { }
                )
            }
        }

        // Loader overlay
//        if (uiState.isLoading)
//            CircularProgressIndicator(color = Color.White, strokeWidth = 4.dp)
    }
}
