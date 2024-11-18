package com.example.tippcalculator
import android.os.Bundle
import android.widget.Switch
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tippcalculator.ui.theme.TippCalculatorTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import java.text.NumberFormat
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.material3.Switch
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Icon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TippCalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    TippApp()
                }
            }
        }
    }
}

@Composable
fun TippApp( modifier: Modifier = Modifier) {

    var amountInput by remember { mutableStateOf("") }
    val amount = amountInput.toDoubleOrNull() ?: 0.0
    var tipInput by remember { mutableStateOf("") } // stores the tip input
    val tipPercent = tipInput.toDoubleOrNull() ?: 0.0
    var roundUp by remember { mutableStateOf(false) }
    val tip = calculateTip(amount, tipPercent, roundUp  )





    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(  // calculate tip text
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        Text(  // tip ammount
            text = stringResource(R.string.tip_amount, tip),   // tip is calling the function
            style = MaterialTheme.typography.displaySmall
        )
        EditNumberField( // bill ammount
            label = R.string.bill_amount,
            keyboardOptions = KeyboardOptions.Default.copy( // passing the keyboard option through as well
                keyboardType = KeyboardType.Number, // the right keyboard // passed as parameter
                imeAction = ImeAction.Next
            ),
            value = amountInput,
            onValueChange = { amountInput = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )
        EditNumberField( // tip percentage
            label = R.string.how_was_the_service,
            keyboardOptions = KeyboardOptions.Default.copy( // keyboard
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done //  the action type changes
            ),
            value = tipInput,
            onValueChange = { tipInput = it },
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth()
        )
        RoundTheTipRow(
            roundUp = roundUp,
            onRoundUpChanged = { roundUp = it },
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}



@Composable
fun EditNumberField(@StringRes label: Int, // allows the label to be specified in the main fucntion
                    keyboardOptions: KeyboardOptions, // the right keyboard passed as parameter
                    value: String,
                    onValueChange: (String) -> Unit, // callback lambda, triggered onvalue change, so the state updates elsewhere, hence the state variables are in the main function
                    modifier: Modifier = Modifier) {


    TextField(
        value = value, // displays the input
        onValueChange = onValueChange, // state change to the input
        singleLine = true, // single line
        label = { Text(stringResource(label)) }, // space holder
        keyboardOptions = keyboardOptions, //(keyboardType = KeyboardType.Number, // the right keyboard
        modifier = modifier
    )
}


@Composable
fun RoundTheTipRow(
    roundUp: Boolean,
    onRoundUpChanged: (Boolean) -> Unit, // This hoists the switch's state.
    modifier: Modifier = Modifier
    ) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.round_up_tip))
        Switch(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            checked = roundUp,
            onCheckedChange = onRoundUpChanged, // callback updates the roundUp state
        )
    }
}

private fun calculateTip(amount: Double, tipPercent: Double = 15.0,roundUp: Boolean): String {
    var tip = tipPercent / 100 * amount
    if (roundUp) {
        tip = kotlin.math.ceil(tip)
    }
    return NumberFormat.getCurrencyInstance().format(tip)
}

@Preview
@Composable
fun GreetingPreview() {
    TippCalculatorTheme {
       TippApp()
    }
}