package org.dev.diceroller.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import org.dev.diceroller.R
import org.dev.diceroller.model.DiceResult
import java.text.SimpleDateFormat
import java.util.*

class MyRecyclerViewAdapter(private val diceResultList: List<DiceResult>) : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvRollNumber: TextView = itemView.findViewById(R.id.tvRollNumber)
        val tvRollResult: TextView = itemView.findViewById(R.id.tvRollResult)
        val tvRollTime: TextView = itemView.findViewById(R.id.tvRollTime)
    }

    override fun getItemCount(): Int {
        return diceResultList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_row, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val diceResult = diceResultList[position]

        holder.tvRollNumber.text = diceResult.rollNumber.toString()
        holder.tvRollResult.text = diceResult.rollResult.toString()
        holder.tvRollTime.text = SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(diceResult.rollTime).toString()
    }
}
