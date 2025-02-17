package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        /* TODO Step 1: Populate this array */
        val numberArray: Array<Int> = Array(50) {2 * (it + 1)}
        for (i in 0..49)
            Log.d("array", "i: ${numberArray[i]}")

        /* TODO Step 2: Create adapter to display items from array in Spinner */
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, numberArray)
        spinner.adapter = adapter

        // TODO Step 3: Change TextView's text size to the number selected in the Spinner */
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                p0?.run {
                    val size: Int = getItemAtPosition(p2) as Int
                    displayTextView.textSize = size.toFloat()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}
        }


    }
}