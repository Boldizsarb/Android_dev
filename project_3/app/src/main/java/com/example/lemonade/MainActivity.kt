package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonade.ui.theme.LemonadeTheme
import androidx.compose.ui.Alignment
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import android.util.Log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeApp( modifier: Modifier = Modifier) {

    var currentStep by remember {mutableStateOf(1)}
    var squeze by remember { mutableStateOf(0) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep){
            1 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text = stringResource(R.string.Lemon_tree))
                    Spacer(modifier = Modifier.height(32.dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = stringResource(R.string.Lemon_tree),
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable {
                                currentStep = 2
                                squeze = (2..4).random() // reset
                            }
                    )
                    }
                }
            2 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(text = stringResource(R.string.Lemon))
                    Spacer(modifier = Modifier.height(32
                        .dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = stringResource(R.string.Lemon),
                        modifier = Modifier.wrapContentSize()
                            .clickable {
                            squeze --
                            if(squeze == 0){
                                currentStep = 3 // jumping to the other picture
                            }
                            Log.d("LemonadeApp", "Squeezed: $squeze times")

                        }
                    )
                }
            }
            3 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(text = stringResource(R.string.Glass_of_lemonade))
                    Spacer(modifier = Modifier.height(32
                        .dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = stringResource(R.string.Glass_of_lemonade),
                        modifier = Modifier.wrapContentSize()
                            .clickable {
                                currentStep = 4
                            }
                    )
                }
            }
            4 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Text(text = stringResource(R.string.Empty_glass))
                    Spacer(modifier = Modifier.height(32
                        .dp))
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = stringResource(R.string.Empty_glass),
                        modifier = Modifier.wrapContentSize()
                            .clickable {
                                currentStep = 1

                            }
                    )
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeApp(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}