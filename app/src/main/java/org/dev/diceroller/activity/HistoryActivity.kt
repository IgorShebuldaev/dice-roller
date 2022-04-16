package org.dev.diceroller.activity

import android.os.Bundle
import android.widget.SearchView
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

        val diceFaceSearch: SearchView = findViewById(R.id.svDiceFace)

        val recyclerView = findViewById<RecyclerView>(R.id.HistoryRecyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val historyRecyclerViewAdapter = HistoryRecyclerViewAdapter(AppRepository.get())

        recyclerView.adapter = historyRecyclerViewAdapter

        diceFaceSearch.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                historyRecyclerViewAdapter.filter.filter(newText)
                return false
            }
        })
    }
}
