package com.codehub.metroapp.list

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codehub.metroapp.R

class RecyclerAdapter : RecyclerView.Adapter<AbstractViewHolder> {
    private val arrayData: List<String>

    constructor(arrayData: List<String>) : super() {
        this.arrayData = arrayData
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)

        return if (viewType == R.layout.holder_item) {
            RecyclerViewHolder(view)
        } else {
            RecyclerViewHolder2(view)
        }
    }

    override fun onBindViewHolder(holder: AbstractViewHolder, position: Int) {
        holder.bind(arrayData[position])
    }

    override fun getItemCount(): Int {
        return arrayData.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) {
            R.layout.holder_item
        } else {
            R.layout.holder_item_2
        }
    }

}

class RecyclerViewHolder(itemView: View) : AbstractViewHolder(itemView) {

    override fun bind(data: String) {
        itemView.findViewById<TextView>(R.id.holder_text).text = data
    }
}

class RecyclerViewHolder2(itemView: View) : AbstractViewHolder(itemView) {

    override fun bind(data: String) {
        itemView.findViewById<TextView>(R.id.holder_text).text = data
        itemView.findViewById<TextView>(R.id.holder_text)
            .setTextColor(ColorStateList.valueOf(Color.RED))
    }
}

abstract class AbstractViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(data: String)
}