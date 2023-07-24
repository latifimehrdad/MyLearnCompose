package ir.agaring.mylearncompose.bill

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import ir.agaring.mylearncompose.bill.components.InputField
import ir.agaring.mylearncompose.ui.theme.MyLearnComposeTheme
import ir.agaring.mylearncompose.ui.theme.Purple80
import ir.agaring.mylearncompose.bill.util.calculateTotalPerson
import ir.agaring.mylearncompose.bill.util.calculateTotalTip
import ir.agaring.mylearncompose.bill.widgets.RoundIconButton

class MainActivity1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp1 {
                MainContent1()
            }
        }
    }
}


//--------------------------------------------------------------------------------------------------
@Composable
fun MyApp1(content: @Composable () -> Unit) {
    MyLearnComposeTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            content()
        }
    }
}
//--------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------
@Composable
fun TopHeader(totalPerPerson: Double = 0.0) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .height(150.dp)
            .clip(shape = CircleShape.copy(all = CornerSize(12.dp))),
        //        .clip(shape = RoundedCornerShape(corner = CornerSize(12.dp)))
        color = Purple80
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val total = "%.2f".format(totalPerPerson)
            Text(
                text = "Total per Person",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "$$total",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )

        }
    }
}
//--------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------
@Preview
@Composable
fun MainContent1() {
    val splitByState = remember {
        mutableStateOf(1)
    }

    val tipAmountState = remember {
        mutableStateOf(0.0)
    }

    val range = IntRange(start = 1, endInclusive = 100)


    val totalPrePersonState = remember {
        mutableStateOf(0.0)
    }

    Column(modifier = Modifier.padding(all = 12.dp)) {
        BillForm(
            splitByState = splitByState,
            tipAmountState = tipAmountState,
            totalPrePersonState = totalPrePersonState,
            range = range
        ) { billAmt ->
            Log.d("meri", "MainContent : $billAmt")
        }
    }
}
//--------------------------------------------------------------------------------------------------


//--------------------------------------------------------------------------------------------------
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BillForm(
    modifier: Modifier = Modifier,
    range: IntRange = 1..100,
    splitByState: MutableState<Int>,
    tipAmountState: MutableState<Double>,
    totalPrePersonState: MutableState<Double>,
    onValChange: (String) -> Unit = {}
) {

    val totalBilState = remember {
        mutableStateOf("")
    }
    val validState = remember(totalBilState.value) {
        totalBilState.value.trim().isNotEmpty()
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    val sliderPositionState = remember {
        mutableStateOf(0f)
    }

    val tipPercentage = (sliderPositionState.value * 100).toInt()


    TopHeader(totalPerPerson = totalPrePersonState.value)

    Surface(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp, color = Color.LightGray)
    ) {
        Column(
            modifier = Modifier.padding(6.dp), verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            InputField(
                valueState = totalBilState,
                labelId = "Enter Bill",
                enable = true,
                isSingleLine = true,
                onAction = KeyboardActions {
                    if (!validState) return@KeyboardActions
                    onValChange(totalBilState.value.trim())
                    keyboardController?.hide()
                }
            )

            if (validState) {
                Row(
                    modifier = modifier.padding(3.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Split", modifier = Modifier.align(
                            alignment = Alignment.CenterVertically
                        )
                    )

                    Spacer(modifier = Modifier.width(120.dp))

                    Row(
                        modifier = Modifier.padding(horizontal = 3.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        RoundIconButton(imageVector = Icons.Default.Remove) {
                            splitByState.value = if (splitByState.value > 1)
                                splitByState.value - 1
                            else 1
                            totalPrePersonState.value = calculateTotalPerson(
                                totalBill = totalBilState.value.toDouble(),
                                splitBy = splitByState.value,
                                tipPercentage = tipPercentage
                            )
                        }

                        Text(
                            text = "${splitByState.value}", modifier = modifier
                                .align(Alignment.CenterVertically)
                                .padding(start = 9.dp, end = 9.dp)
                        )

                        RoundIconButton(imageVector = Icons.Default.Add) {
                            if (splitByState.value < range.last)
                                splitByState.value += 1
                            totalPrePersonState.value = calculateTotalPerson(
                                totalBill = totalBilState.value.toDouble(),
                                splitBy = splitByState.value,
                                tipPercentage = tipPercentage
                            )
                        }
                    }

                }

                Row(
                    modifier = modifier.padding(horizontal = 3.dp, vertical = 12.dp)
                ) {

                    Text(
                        text = "Tip",
                        modifier = Modifier.align(alignment = Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(200.dp))

                    Text(
                        text = "$ ${tipAmountState.value}",
                        modifier = Modifier.align(alignment = Alignment.CenterVertically)
                    )
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "$tipPercentage %")
                    Spacer(modifier = Modifier.height(14.dp))
                    Slider(
                        value = sliderPositionState.value,
                        onValueChange = { newVal ->
                            sliderPositionState.value = newVal
                            if (totalBilState.value.isDigitsOnly()) {
                                tipAmountState.value = calculateTotalTip(
                                    totalBill = totalBilState.value.toDouble(),
                                    tipPercentage = tipPercentage
                                )
                                totalPrePersonState.value = calculateTotalPerson(
                                    totalBill = totalBilState.value.toDouble(),
                                    splitBy = splitByState.value,
                                    tipPercentage = tipPercentage
                                )
                            }
                        },
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    )
                }

            } else {
                Box() {

                }
            }
        }
    }
}
//--------------------------------------------------------------------------------------------------


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyLearnComposeTheme {
        MyApp1 {
            Text(text = "Hello Again")
        }
    }
}