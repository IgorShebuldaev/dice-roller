package org.dev.diceroller.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.dev.diceroller.R
import org.dev.diceroller.models.DiceResult
import org.dev.diceroller.models.faceImageResource
import java.text.SimpleDateFormat
import java.util.*

class HistoryListAdapter : ListAdapter<DiceResult, HistoryListAdapter.DiceViewHolder>(DiceComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiceViewHolder {
        return DiceViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: DiceViewHolder, position: Int) {
        val diceResult = getItem(position)

        holder.tvRollNumber.text = diceResult.id.toString()
        holder.ivRollResult.setImageResource(faceImageResource(diceResult.face))
        holder.tvRollTime.text = SimpleDateFormat("HH:mm:ss", Locale.ENGLISH).format(diceResult.createdAt).toString()
    }

    class DiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvRollNumber: TextView = itemView.findViewById(R.id.tvRollNumber)
        val ivRollResult: ImageView = itemView.findViewById(R.id.ivRollResult)
        val tvRollTime: TextView = itemView.findViewById(R.id.tvRollTime)

        companion object {
            fun create(parent: ViewGroup): DiceViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_row, parent, false)
                return DiceViewHolder(view)
            }
        }
    }

    class DiceComparator : DiffUtil.ItemCallback<DiceResult>() {
        override fun areItemsTheSame(oldItem: DiceResult, newItem: DiceResult): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DiceResult, newItem: DiceResult): Boolean {
            return oldItem.face.value == newItem.face.value
        }
    }
}
