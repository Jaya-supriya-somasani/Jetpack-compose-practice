package com.example.jetpackcomposepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.tree)
            val desc = "Image card view"
            val title = "This is the sample card view with image"
            val names = listOf("jaya", "priya", "uma", "geetha","Seetha")
            MaterialTheme.typography
            Column {
                Row {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding(16.dp)
                        ) {
                            ImageCard(painter = painter, contentDescription = desc, title = title)
                        }
                        Spacer(modifier = Modifier.width(60.dp))
                        Text(text = "image description",
                            Modifier
                                .padding(start = 40.dp)
                                .clickable { })
                    }
                    Column(modifier = Modifier.fillMaxWidth()) {

                        Text("Hello", Modifier.clickable { })
                        Text("World")
                        Text("Hello")
                        Text("World")
                        Text("jaya")
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column() {
//c1
                        Text("Hello",
                            Modifier.clickable { })
                        Text("World")
                        Text("Hello")
                        Text("World")
                        Text("jaya")
                    }
                    Column {
                        //c2
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(1f)
                                .padding(16.dp)
                        ) {
                            ImageCard(painter = painter, contentDescription = desc, title = title)

                        }
                    }
                }
                Row(modifier = Modifier.padding(all = 20.dp)) {

                    Image(
                        painter = painterResource(id = R.drawable.tree),
                        contentDescription = "sample image 2",
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .border(
                                BorderStroke(2.dp, Color.Red),
                                CircleShape
                            ),
                        contentScale = ContentScale.Crop
                    )
                    Greetings(name = names)

                }
                UserName()
            }
        }
    }
}

@Composable
fun Greetings(name: List<String>) {
    for (user in name) {
        Text(text = "hello $user", modifier = Modifier.padding(start = 20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
//    Greetings(name = "Jaya")
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(180.dp)) {
            Image(
                painter = painter,
                modifier = Modifier
                    .fillMaxSize(),
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent, Color.White
                            ), startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp), contentAlignment = Alignment.BottomStart
            ) {
                Text(title, style = TextStyle(color = Color.Black, fontSize = 12.sp))

            }
        }
    }
}


// here we are using stateful for remembering the user name and we created outline text box and we can change the colors of label text and outline box color when we focused and unfocused
@Composable
fun UserName() {
    Column(modifier = Modifier.padding(16.dp)) {
        var name by remember { mutableStateOf("") }
        Text(
            text = "Hello, $name!",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.h5
        )
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name")},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Red, focusedLabelColor = Color.Magenta, unfocusedLabelColor = Color.Red
            )
        )
    }

}