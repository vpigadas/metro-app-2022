package com.codehub.metroapp.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.codehub.metroapp.R

class RecyclerListAdapter : ListAdapter<String, AbstractViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)

        return if (viewType == R.layout.holder_item) {
            RecyclerViewHolder(view)
        } else {
            RecyclerViewHolder2(view)
        }
    }

    override fun onBindViewHolder(holder: AbstractViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) {
            R.layout.holder_item
        } else {
            R.layout.holder_item_2
        }
    }
}