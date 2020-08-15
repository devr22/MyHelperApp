package com.example.myhelperapp.customLayouts.customtable

import android.content.Context
import android.view.Gravity
import android.widget.*
import com.example.myhelperapp.R

class TableHelper(val context: Context, private val tableLayout: TableLayout) {

    fun addTableRow() {
        val tableRow = TableRow(context)

        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        tableRow.layoutParams = layoutParams
        tableRow.minimumHeight = 220
        tableRow.gravity = Gravity.CENTER

        val snoTv = TextView(context)
        snoTv.text = "1"
        tableRow.addView(snoTv, 0)

        val qualificationSpinner = Spinner(context)
        tableRow.addView(qualificationSpinner, 1)

        val yearEt = EditText(context)
        yearEt.background = context.getDrawable(R.drawable.table_edit_text_bg)
        tableRow.addView(yearEt, 2)

        val boardEt = EditText(context)
        boardEt.background = context.getDrawable(R.drawable.table_edit_text_bg)
        tableRow.addView(boardEt, 3)

        val imageView = ImageView(context)
        val layout_params = LinearLayout.LayoutParams(200, 200)
        imageView.layoutParams = layout_params
        tableRow.addView(imageView, 4)

        val textView = TextView(context)
        tableRow.addView(textView, 5)

        val textView1 = TextView(context)
        tableRow.addView(textView1, 6)

        tableLayout.addView(tableRow)

    }

}