package com.sign.bottomnavtest

import java.util.*

object InitCurrentDate {

    private val calendar:Calendar = Calendar.getInstance()
    private val day = calendar.get(Calendar.DAY_OF_MONTH)
    private val month = calendar.get(Calendar.MONTH)
    private val year = calendar.get(Calendar.YEAR)

    val instance:DateValue
    get() = DateValue(day = day,month = month+1,year = year)


}