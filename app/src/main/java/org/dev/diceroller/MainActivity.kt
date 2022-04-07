package org.dev.diceroller

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import org.dev.diceroller.model.DiceResult
import java.util.*

class MainActivity : AppCompatActivity() {
    private var ivDice: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivDice = findViewById(R.id.ivDice)
        val bRoll: Button = findViewById(R.id.bRoll)
        val bHistory: Button = findViewById(R.id.bHistory)

        var counter = 0

        bRoll.setOnClickListener {
            Repo.diceResultList.add(DiceResult(++counter, Dice().roll(), Calendar.getInstance().time))
            setImageResource(Repo.diceResultList.last().rollResult)
        }

        bHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setImageResource(number: Int) {
        when (number) {
            1 -> ivDice?.setImageResource(R.drawable.dice_1)
            2 -> ivDice?.setImageResource(R.drawable.dice_2)
            3 -> ivDice?.setImageResource(R.drawable.dice_3)
            4 -> ivDice?.setImageResource(R.drawable.dice_4)
            5 -> ivDice?.setImageResource(R.drawable.dice_5)
            else -> ivDice?.setImageResource(R.drawable.dice_6)
        }
    }
}
