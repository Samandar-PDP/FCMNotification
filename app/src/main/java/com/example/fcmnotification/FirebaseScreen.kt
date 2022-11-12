package com.example.fcmnotification

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.google.firebase.messaging.FirebaseMessaging

@Composable
fun FirebaseScreen() {
    val context = LocalContext.current
    var token: String? = null
    FirebaseMessaging.getInstance().token
        .addOnCompleteListener {
            if (!it.isSuccessful) {
                token = "Failed ${it.exception?.message}"
                return@addOnCompleteListener
            }
            token = it.result
            Toast.makeText(context, "$token", Toast.LENGTH_SHORT).show()
        }
    LaunchedEffect(key1 = Unit) {
        if (token != null) {
            Log.d("@@@Token", token.toString())
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            color = Color.Black,
            fontSize = 20.sp
        )
    }
}