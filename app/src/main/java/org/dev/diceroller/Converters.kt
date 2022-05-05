package org.dev.diceroller

import androidx.room.TypeConverter
import org.dev.diceroller.models.Face

class Converters {
    @TypeConverter
    fun intToObject(value: Int?): Face? {
        return value?.let { Face(it) }
    }

    @TypeConverter
    fun fromObjectToInt(face: Face?): Int? {
        return face?.value
    }
}
