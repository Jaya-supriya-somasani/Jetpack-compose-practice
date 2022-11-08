package com.example.jetpackcomposepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
            Column() {
                Row {
                    Column(horizontalAlignment = Alignment.End) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding(16.dp)
                        ) {
                            ImageCard(painter = painter, contentDescription = desc, title = title)

                        }
                    }
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .background(Color.LightGray)
                            .border(2.dp, Color.Magenta)
                            .padding(20.dp)
                            .border(2.dp, Color.Blue)
                            .padding(20.dp)
                            .border(2.dp, Color.DarkGray)
                            .padding(25.dp)
                    ) {

                        Text("Hello",
                            Modifier
                                .offset((60).dp, (80).dp)
                                .clickable { })
                        Text("World")
                        Text("Hello")
                        Text("World")
                        Text("jaya")
                    }
                }
                Row(verticalAlignment = Alignment.Bottom) {
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .background(Color.LightGray)
                            .border(2.dp, Color.Magenta)
                            .padding(20.dp)
                            .border(2.dp, Color.Blue)
                            .padding(20.dp)
                            .border(2.dp, Color.DarkGray)
                            .padding(25.dp)
                    ) {

                        Text("Hello",
                            Modifier
                                .offset((60).dp, (80).dp)
                                .clickable { })
                        Text("World")
                        Text("Hello")
                        Text("World")
                        Text("jaya")
                    }
                    Column {
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
                            .wrapContentSize()
                            .clip(CircleShape)
                            .border(
                                BorderStroke(2.dp, Color.Red),
                                CircleShape
                            )
                    )

                }
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