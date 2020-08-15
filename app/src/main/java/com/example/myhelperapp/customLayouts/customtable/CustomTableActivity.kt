package com.example.myhelperapp.customLayouts.customtable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.myhelperapp.R
import kotlinx.android.synthetic.main.activity_custom_table.*

class CustomTableActivity : AppCompatActivity() {

    private lateinit var tableLayout: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_table)

        tableLayout = findViewById(R.id.table_layout)
        tableLayout.isStretchAllColumns

        table_add_row.setOnClickListener {
            val tableHelper = TableHelper(this, tableLayout)
            tableHelper.addTableRow()
        }

    }

    private fun addTableRow() {
        val tableRow = TableRow(this)

        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        tableRow.layoutParams = layoutParams
        tableRow.minimumHeight = 150

        val textView = TextView(this)
        textView.text = "1"
        tableRow.addView(textView, 0)

        val spinner = Spinner(this)
        tableRow.addView(spinner, 1)

        val qualificationEt = EditText(this)
        tableRow.addView(qualificationEt, 2)

        val boardEt = EditText(this)
        tableRow.addView(boardEt, 3)

        val button = Button(this)
        tableRow.addView(button, 4)

        val textView4 = TextView(this)
        tableRow.addView(textView4, 5)

        val textView5 = TextView(this)
        tableRow.addView(textView5, 6)

        tableLayout.addView(tableRow)

    }

}