package org.dev.diceroller.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.dev.diceroller.R

@Entity(tableName = "dice_result")
data class DiceResult(@ColumnInfo(name = "face") val face: Face) {
    @PrimaryKey(autoGenerate = true) var id: Int? = null
    @ColumnInfo(name = "created_at") var createdAt: Long = System.currentTimeMillis()
}


class InvalidFaceException(message: String?) : java.lang.Exception(message)
class Face(val value: Int) {
    init {
        if (value < 1 || value > 6) {
            throw InvalidFaceException("Fuck you bitch")
        }
    }
}

fun nextRoll(): Face {
    return Face((1..6).shuffled().last())
}

fun faceImageResource(face: Face): Int {
    return when (face.value) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}
