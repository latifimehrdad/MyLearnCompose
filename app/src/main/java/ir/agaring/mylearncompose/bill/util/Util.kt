package ir.agaring.mylearncompose.bill.util

/**
 * Created by m-latifi on 7/8/2023.
 */

//-------------------------------------------------------------------------------------------------- calculateTotalTip
fun calculateTotalTip(totalBill: Double, tipPercentage: Int): Double {
    return if (totalBill > 1 && totalBill.toString().isNotEmpty())
        (totalBill * tipPercentage) / 100 else 0.0
}
//-------------------------------------------------------------------------------------------------- calculateTotalTip


//-------------------------------------------------------------------------------------------------- calculateTotalPerson
fun calculateTotalPerson(
    totalBill: Double,
    splitBy: Int,
    tipPercentage: Int
): Double {
    val bill = calculateTotalTip(totalBill = totalBill, tipPercentage = tipPercentage) + totalBill
    return (bill / splitBy)
}
//-------------------------------------------------------------------------------------------------- calculateTotalPerson