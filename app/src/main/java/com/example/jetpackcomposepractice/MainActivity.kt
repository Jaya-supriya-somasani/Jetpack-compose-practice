package com.example.jetpackcomposepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .border(2.dp, Color.Magenta)
                    .padding(20.dp)
            ) {
                Text("Hello",Modifier.offset((-50).dp, (80).dp))
                Text("World")
                Text("Hello")
                Text("World")
                Text("jaya")
            }

        }
    }
}

@Composable
fun Greetings(name: String) {
    Text(text = "hello $name")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Greetings(name = "Jaya")
}
