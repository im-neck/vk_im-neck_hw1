package com.example.dz

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NumberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val text: TextView = itemView.findViewById(R.id.numberText)

    fun bind(number: Int, evenColor: Int, oddColor: Int) {
        text.text = number.toString()

        val bg = if (number % 2 == 0) evenColor else oddColor
        itemView.setBackgroundColor(bg)
    }
}
