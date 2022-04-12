package org.dev.diceroller

import org.dev.diceroller.models.DiceResult
import org.dev.diceroller.models.Face
import java.util.*

var AppRepository: Repository = TempRepository

interface Repository {
    fun total(): Int
    fun create(face: Face)
    fun get(): ArrayList<DiceResult>
    fun search(term: String): ArrayList<DiceResult>
}

object TempRepository : Repository {
    private val storage: ArrayList<DiceResult> = ArrayList()
    private var counter: Int = 0

    override fun total(): Int {
        return storage.size;
    }

    override fun create(face: Face) {
        storage.add(DiceResult(++counter, face, Calendar.getInstance().timeInMillis))
    }

    override fun get(): ArrayList<DiceResult> {
        return storage
    }

    override fun search(term: String): ArrayList<DiceResult> {
        TODO("Not yet implemented")
    }
}

object RoomRepository : Repository {
    override fun total(): Int {
        TODO("Not yet implemented")
    }

    override fun create(face: Face) {
        TODO("Not yet implemented")
    }

    override fun get(): ArrayList<DiceResult> {
        TODO("Not yet implemented")
    }

    override fun search(term: String): ArrayList<DiceResult> {
        TODO("Not yet implemented")
    }
}
