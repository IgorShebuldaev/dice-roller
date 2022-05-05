package org.dev.diceroller

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import org.dev.diceroller.models.DiceDao
import org.dev.diceroller.models.DiceResult

class DiceRepository(private val diceDao: DiceDao) {
    val result: Flow<List<DiceResult>> = diceDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(diceResult: DiceResult) {
        diceDao.insert(diceResult)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun search(face: Int) : LiveData<List<DiceResult>> {
        return diceDao.getByFace(face)
    }
}
