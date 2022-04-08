package org.dev.diceroller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import org.dev.diceroller.activity.HistoryActivity
import org.dev.diceroller.models.Dice
import org.dev.diceroller.models.DiceResult
import org.dev.diceroller.models.getResourceValue
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ivDice: ImageView = findViewById(R.id.ivDice)
        val bRoll: Button = findViewById(R.id.bRoll)
        val bHistory: Button = findViewById(R.id.bHistory)

        var counter = 0

        bRoll.setOnClickListener {
            Repository.diceResultList.add(DiceResult(++counter, Dice().roll(), Calendar.getInstance().time))
            ivDice.setImageResource(getResourceValue(Repository.diceResultList.last().rollResult))
        }

        bHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }
}
