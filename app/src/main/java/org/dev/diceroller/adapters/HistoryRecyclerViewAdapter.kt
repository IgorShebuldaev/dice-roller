package org.dev.diceroller.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.dev.diceroller.R
import org.dev.diceroller.models.DiceResult
import org.dev.diceroller.models.faceImageResource
import java.text.SimpleDateFormat
import java.util.*

class HistoryRecyclerViewAdapter(private val diceResultList: ArrayList<DiceResult>) : RecyclerView.Adapter<HistoryRecyclerViewAdapter.ViewHolder>(), Filterable {

    var diceResultFilterList = ArrayList<DiceResult>()

    init {
        diceResultFilterList = diceResultList
    }

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

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                diceResultFilterList = if (charSearch.isEmpty()) {
                    diceResultList
                } else {
                    val resultList = ArrayList<DiceResult>()
                    for (row in diceResultList) {
                        if (row.face.value.toString().contains(charSearch)) {
                            resultList.add(row)
                        }
                    }
                    resultList
                }
                val filterResults = FilterResults()
                filterResults.values = diceResultFilterList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                diceResultFilterList = results?.values as ArrayList<DiceResult>
                notifyDataSetChanged()
            }
        }
    }
}
