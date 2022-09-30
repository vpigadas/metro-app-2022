package com.codehub.metroapp.list

import androidx.recyclerview.widget.DiffUtil

class DiffCallback<T : Any> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(o: T, t1: T): Boolean {
        return o == t1
    }

    override fun areContentsTheSame(o: T, t1: T): Boolean {
        return false
    }
}