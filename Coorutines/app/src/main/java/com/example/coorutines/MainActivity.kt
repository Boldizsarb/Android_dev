package com.example.coorutines

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.coorutines.ui.theme.CoorutinesTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoorutinesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        /*   // Gloabal coorutines
        GlobalScope.launch (Dispatchers.Main){ // global coorutine - global means the coorutine lives until the application does
            delay(3000L)  // only pauses the coorutine unlike sleep() /// delays can only called from withing a coorutine
            Log.d(TAG,"Starting coorutine, hello from ${Thread.currentThread().name}")
        }
        Log.d(TAG," hello from ${Thread.currentThread().name}")

        GlobalScope.launch (Dispatchers.IO){ // IO is used for data operations
            Log.d(TAG,"Starting coorutine, hello from ${Thread.currentThread().name}")
            val answer = doNetworkCall()
            withContext(Dispatchers.Main){ // this switches thread to the chosen thread
                // this block will be executed in the main thread
                Log.d(TAG,"Setting text in  ${Thread.currentThread().name}")
            }
        }
        ////////////////////////  Blocking the main thread!

        Log.d(TAG,"Before runBlock")
        runBlocking { // it blocks the main thread
            launch (Dispatchers.IO){ // can launch another coorutine from within,
                // the io thread is not blocked by the runblocking
                delay(3000L)
                Log.d(TAG,"finished IO")
            }
            Log.d(TAG,"Start of the runBlocking")
            delay(6000L)
            Log.d(TAG,"End of runBlocking")
        }
        Log.d(TAG,"After runBlocking")

         */

        /*    // run blocking
        val job = GlobalScope.launch(Dispatchers.Default) { // every launch function returns a job
            repeat(5){
                Log.d(TAG,"=Coorutine is still working ....")
                delay(1000L)
            }
        }

        runBlocking {
            delay(2000L)
            job.cancel() // cancels the job after 2s
            //job.join() // waiting for the return of the job // join can only be called from coorutine scope
            // the join function will block all thread till the job is finished
            Log.d(TAG,"Main thread is continuing....")

        }

         */
     //////  new activity


    }
}

suspend fun doNetworkCall(): String { // delaying function
    delay(3000L)
    return "This is the answer"
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoorutinesTheme {
        Greeting("Android")
    }
}