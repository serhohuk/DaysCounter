package com.sign.bottomnavtest

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_between_dates.*
import kotlinx.android.synthetic.main.fragment_to_date.*


class ToDateFragment : Fragment() {
    lateinit var dateNow:DateValue
    lateinit var chosenDate:DateValue

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        datePickerListener()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dateNow = InitCurrentDate.instance
        return inflater.inflate(R.layout.fragment_to_date, container, false)
    }

    private fun datePickerListener(){
        Log.d("TEST","RUNABLE")
        date_picker?.init(dateNow.year,dateNow.month-1,dateNow.day,
            DatePicker.OnDateChangedListener { view, i, i2, i3 ->
                with(view) {
                    chosenDate = DateValue(day = dayOfMonth, month = month+1, year = year)
                }
                val timeBetweenDates = TimeBetweenDates(chosenDate)
                with(timeBetweenDates){years_months_days.text = updateText(getYearsNumber(),getMonthsNumber(),getDaysNumber())
                    months_value.text = months.toString()
                    weeks_value.text = weeks.toString()
                    days_value.text = days.toString()
                    hours_value.text = hours.toString()
                    minutes_value.text = minutes.toString()
                }

            }
        )
    }

    private fun updateText(years:Int,months:Int,days:Int):String{
        return "Years  $years  Months  $months  Days  $days"
    }
}