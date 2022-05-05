package org.dev.diceroller.activity

import android.os.Bundle
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.dev.diceroller.DiceApplication
import org.dev.diceroller.DiceViewModel
import org.dev.diceroller.DiceViewModelFactory
import org.dev.diceroller.R
import org.dev.diceroller.adapters.HistoryListAdapter

class HistoryActivity : AppCompatActivity() {
    private val diceViewModel: DiceViewModel by viewModels {
        DiceViewModelFactory((application as DiceApplication).repository)
    }
    private val historyListAdapter= HistoryListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        title = resources.getString(R.string.history)

        val recyclerView = findViewById<RecyclerView>(R.id.HistoryRecyclerView)
        val diceFaceSearch: SearchView = findViewById(R.id.svDiceFace)

        recyclerView.adapter = historyListAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        updateListAdapter()

        diceFaceSearch.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                executeWhere(query)

                return true
            }

            override fun onQueryTextChange(query: String): Boolean {
                executeWhere(query)

                return false
            }
        })

    }

    private fun executeWhere(str: String) {
        if (str.isEmpty() || !(str.isDigitsOnly())) { updateListAdapter(); return }

        diceViewModel.search(str.toInt()).observe(this) { dice ->
            dice.let {
                historyListAdapter.submitList(it)
            }
        }

    }

    private fun updateListAdapter() {
        diceViewModel.result.observe( this) { dice ->
            dice.let { historyListAdapter.submitList(it) }
        }
    }
}
