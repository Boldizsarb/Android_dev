package com.example.setup.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.setup.R
import com.example.setup.ui.theme.DarkRed




@Composable
fun SharedLayout(

    seatNumber: String,
    destination: String,
    mainText: String,
    onButtonClick: () -> Unit,
    showButtons: Boolean = false // false by default since the buttons are on the second screen
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Color.Red, DarkRed)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Top Section with seat number and destination
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = seatNumber,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = destination,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White
                )
            }

            // Center section
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = mainText,
                    fontSize = 72.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Yellow
                )
            }
            // Bottom Section with buttons and logo
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.iberia_logo),
                        contentDescription = "Iberia Logo",
                        modifier = Modifier.size(100.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = ".air",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    if (showButtons){
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(end = 16.dp), // padding between edges
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.End // placing button onto the right side
                        ){
                            Button(onClick = onButtonClick,
                                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.padding(8.dp)) {
                                // inside button
                                Text("English", color = Color.White)
                            }
                            Spacer(modifier = Modifier.width(4.dp)) // bit of space inbetween
                            Button(onClick = onButtonClick,
                                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                                shape = RoundedCornerShape(8.dp),
                                modifier = Modifier.padding(8.dp)) {
                                Text("Espanol")
                            }
                        }
                    }

                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}