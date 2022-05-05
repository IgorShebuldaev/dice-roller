package org.dev.diceroller.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import org.dev.diceroller.DiceApplication
import org.dev.diceroller.DiceViewModel
import org.dev.diceroller.DiceViewModelFactory
import org.dev.diceroller.R
import org.dev.diceroller.models.DiceResult
import org.dev.diceroller.models.faceImageResource
import org.dev.diceroller.models.nextRoll

class MainActivity : AppCompatActivity() {
    private val diceViewModel: DiceViewModel by viewModels {
        DiceViewModelFactory((application as DiceApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ivDice: ImageView = findViewById(R.id.ivDice)
        val bRoll: Button = findViewById(R.id.bRoll)
        val bHistory: Button = findViewById(R.id.bHistory)

        bRoll.setOnClickListener {
            val face = nextRoll()
            diceViewModel.insert(DiceResult(null, face, System.currentTimeMillis()))
            ivDice.setImageResource(faceImageResource(face))
        }

        bHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }
}
