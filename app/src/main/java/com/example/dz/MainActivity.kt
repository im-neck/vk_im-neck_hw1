package com.example.dz

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var adapter: NumberAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numbers = savedInstanceState?.getIntegerArrayList("items")
            ?: arrayListOf()

        recycler = findViewById(R.id.recycler)

        val columns = getColumnCount()

        adapter = NumberAdapter(
            numbers,
            evenColor = getColor(R.color.redSquare),
            oddColor = getColor(R.color.blueSquare)
        )

        recycler.layoutManager = GridLayoutManager(this, columns)
        recycler.adapter = adapter

        findViewById<FloatingActionButton>(R.id.addButton).setOnClickListener {
            adapter.addItem()
            recycler.smoothScrollToPosition(adapter.itemCount - 1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val list = ArrayList<Int>()
        for (i in 0 until adapter.itemCount) {
            list.add(i)
        }
        outState.putIntegerArrayList("items", list)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        val columns = getColumnCount()
        (recycler.layoutManager as GridLayoutManager).spanCount = columns
    }

    private fun getColumnCount(): Int {
        val portrait = resources.getInteger(R.integer.portrait_columns)
        val landscape = resources.getInteger(R.integer.landscape_columns)

        return if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            portrait
        else
            landscape
    }
}