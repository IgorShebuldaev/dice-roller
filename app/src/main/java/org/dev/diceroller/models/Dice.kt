package org.dev.diceroller.models

import org.dev.diceroller.R
import java.util.*

data class DiceResult(val rollNumber: Int, val rollResult: Int, val rollTime: Date)

class Dice {

    fun roll(): Int {
        return (1..6).random()
    }
}

fun getResourceValue(number: Int): Int {
    return when (number) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}
