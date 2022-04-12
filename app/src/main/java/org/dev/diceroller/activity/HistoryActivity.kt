package org.dev.diceroller.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.dev.diceroller.AppRepository
import org.dev.diceroller.R
import org.dev.diceroller.adapters.HistoryRecyclerViewAdapter

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        title = "History"

        val recyclerView = findViewById<RecyclerView>(R.id.HistoryRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val myRecyclerViewAdapter = HistoryRecyclerViewAdapter(AppRepository.get())

        recyclerView.adapter = myRecyclerViewAdapter
    }
}
