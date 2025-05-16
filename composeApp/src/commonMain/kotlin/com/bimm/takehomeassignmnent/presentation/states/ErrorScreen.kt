package com.bimm.takehomeassignmnent.presentation.states

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ErrorScreen(
    message: String,
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Oops! Something went wrong.", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = message, style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onRetry) {
            Text("Try Again")
        }
    }
}