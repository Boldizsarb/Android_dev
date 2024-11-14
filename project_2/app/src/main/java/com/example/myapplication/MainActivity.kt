package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge() // not sure its needed
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = stringResource(R.string.message),
                        anotherText = stringResource(R.string.from),
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(message: String, anotherText: String, modifier: Modifier = Modifier) {

    Column (verticalArrangement = Arrangement.Center,
        modifier = modifier){

        Text(
            text = message,
            // modifier = modifier
            fontSize = 30.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = anotherText,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End),
            color = Color.Red
        )
    }
}

@Composable
// image
fun GreetingImage(message: String, anotherText: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.resource_this)
    Box(modifier.fillMaxSize()) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop, // places it on to the middle
            alpha = 0.8F // opacity
        )
        Greeting(message = message, anotherText = anotherText,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true) // this is just the preview
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        //Greeting("First app with Compose","This is cool")
        GreetingImage("First app with Compose","This is cool")
    }
}