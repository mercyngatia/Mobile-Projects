package com.example.agecalculator

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)
        val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)
        btnDatePicker.setOnClickListener { view ->
        clickDatePicker(view)
        }
    }
  // @RequiresApi(Build.VERSION_CODES.N)
    fun clickDatePicker(view: View) {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->
//             Toast.makeText(this,
//                     "The chosen year is $selectedYear, the month is $selectedMonth and the day is $selectedDayOfMonth"
//                     , Toast.LENGTH_LONG).show()
             val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

                    tvSelectedDate.setText(selectedDate)
                    val sdf = SimpleDateFormat("dd/MM/yyy", Locale.ENGLISH)
                    val  theDate = sdf.parse(selectedDate)

                    val selectedDateToMinutes = theDate!!.time / 60000
                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    //current date in to minutes
                    val currectDateToMinutes = currentDate!!.time / 60000

                    //Difference in minutes
                    val differenceInMinutes = currectDateToMinutes - selectedDateToMinutes
                    //Difference in minutes to textView
                    tvSelectedDateInMinutes.setText(differenceInMinutes.toString())
          },
                 year,
                 month,
                 day)
      dpd.datePicker.setMaxDate(Date().time - 86400000)
      dpd.show() //shows the datePicker dialog
    }

}