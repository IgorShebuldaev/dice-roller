package org.dev.diceroller.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.dev.diceroller.R
import org.dev.diceroller.models.DiceResult
import org.dev.diceroller.models.faceImageResource
import java.text.SimpleDateFormat
import java.util.*

class HistoryRecyclerViewAdapter(private val diceResultList: List<DiceResult>) : RecyclerView.Adapter<HistoryRecyclerViewAdapter.ViewHolder>() {
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

        holder.tvRollNumber.text = diceResult.id.toString()
        holder.ivRollResult.setImageResource(faceImageResource(diceResult.face))
        holder.tvRollTime.text = SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(diceResult.createdAt).toString()
    }
}
