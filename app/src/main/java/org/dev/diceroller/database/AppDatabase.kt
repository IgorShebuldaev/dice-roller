package org.dev.diceroller.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.dev.diceroller.Converters
import org.dev.diceroller.models.DiceDao
import org.dev.diceroller.models.DiceResult

@Database(entities = [DiceResult::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun diceDao(): DiceDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "dice_roller")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}
