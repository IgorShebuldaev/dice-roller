package org.dev.diceroller.models

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DiceDao {
    @Insert
    suspend fun insert(diceResult: DiceResult)

    @Query("select * from dice_result")
    fun getAll(): Flow<List<DiceResult>>

    @Query("select * from dice_result where face in (:face)")
    fun getByFace(face: String): LiveData<List<DiceResult>>
}
