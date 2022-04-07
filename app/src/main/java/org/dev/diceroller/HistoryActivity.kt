package org.dev.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.dev.diceroller.adapter.MyRecyclerViewAdapter

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val recyclerView = findViewById<RecyclerView>(R.id.diceResultRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val myRecyclerViewAdapter = MyRecyclerViewAdapter(Repo.diceResultList)

        recyclerView.adapter = myRecyclerViewAdapter
    }
}