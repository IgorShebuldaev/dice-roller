package org.dev.diceroller

import android.app.Application
import org.dev.diceroller.database.AppDatabase

class DiceApplication : Application() {
    private val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { DiceRepository(database.diceDao()) }
}
