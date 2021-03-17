package com.sign.bottomnavtest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import kotlinx.android.synthetic.main.fragment_between_dates.*


class BetweenDatesFragment : Fragment() {
    lateinit var firstDate:DateValue
    lateinit var secondDate:DateValue

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        firstDate = InitCurrentDate.instance
        secondDate = InitCurrentDate.instance
        return inflater.inflate(R.layout.fragment_between_dates, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        datePickerListener()
    }


    private fun datePickerListener(){
        date_picker1?.init(firstDate.year,firstDate.month-1,firstDate.day,
            DatePicker.OnDateChangedListener { view, i, i2, i3 ->
                with(view) { firstDate = DateValue(day = dayOfMonth, month = month+1, year = year) }
                setNewText()
            }
        )
        date_picker2?.init(secondDate.year,secondDate.month-1,secondDate.day,
            DatePicker.OnDateChangedListener { view, i, i2, i3 ->
                with(view) { secondDate = DateValue(day = dayOfMonth, month = month+1, year = year) }
                setNewText()
            }
        )
    }


    private fun setNewText(){
        val timeBetweenDates = TimeBetweenDates(firstDate,secondDate)
        with(timeBetweenDates){years_months_days1.text = updateText(getYearsNumber(),getMonthsNumber(),getDaysNumber())
            months_value1.text = months.toString()
            weeks_value1.text = weeks.toString()
            days_value1.text = days.toString()
            hours_value1.text = hours.toString()
            minutes_value1.text = minutes.toString()

        }
    }

    private fun updateText(years:Int,months:Int,days:Int):String{
        return "Years  $years  Months  $months  Days  $days"
    }

}