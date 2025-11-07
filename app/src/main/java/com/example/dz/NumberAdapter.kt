package com.example.dz

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter(
    private val numbers: MutableList<Int>,
    private val evenColor: Int,
    private val oddColor: Int
) : RecyclerView.Adapter<NumberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_square, parent, false)
        return NumberViewHolder(view)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.bind(numbers[position], evenColor, oddColor)
    }

    override fun getItemCount(): Int = numbers.size

    fun addItem() {
        numbers.add(numbers.size)
        notifyItemInserted(numbers.lastIndex)
    }
}
