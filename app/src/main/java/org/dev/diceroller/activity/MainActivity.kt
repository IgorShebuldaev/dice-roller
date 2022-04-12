package org.dev.diceroller.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import org.dev.diceroller.AppRepository
import org.dev.diceroller.R
import org.dev.diceroller.models.faceImageResource
import org.dev.diceroller.models.nextRoll

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ivDice: ImageView = findViewById(R.id.ivDice)
        val bRoll: Button = findViewById(R.id.bRoll)
        val bHistory: Button = findViewById(R.id.bHistory)

        bRoll.setOnClickListener {
            val face = nextRoll()
            AppRepository.create(face)
            ivDice.setImageResource(faceImageResource(face))
        }

        bHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }
}
