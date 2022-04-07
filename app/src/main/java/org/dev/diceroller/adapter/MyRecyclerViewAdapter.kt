package org.dev.diceroller.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.dev.diceroller.R
import org.dev.diceroller.model.DiceResult
import java.text.SimpleDateFormat
import java.util.*

class MyRecyclerViewAdapter(private val diceResultList: List<DiceResult>) : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val tvRollNumber: TextView = itemView.findViewById(R.id.tvRollNumber)
        val ivRollResult: ImageView = itemView.findViewById(R.id.ivRollResult)
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
        holder.ivRollResult.setImageResource(getResourceValue(diceResult.rollResult))
        holder.tvRollTime.text = SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(diceResult.rollTime).toString()
    }

    private fun getResourceValue(number: Int): Int {
        return when (number) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}
