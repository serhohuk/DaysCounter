package com.sign.bottomnavtest

import org.joda.time.LocalDate
import  org.joda.time.Days
import  org.joda.time.Months
import  org.joda.time.Years


class TimeBetweenDates(toDate:DateValue){

    var fromDateString: LocalDate?=null
    var toDateString: LocalDate?=null
    var daysBetween:Int?=null

    var months:Int = 0
    var weeks:Int = 0
    var days:Int = 0
    var hours:Int = 0
    var minutes:Int = 0

    val DAYS_IN_WEEK = 7
    val HOURS_IN_DAY = 24
    val MINUTES_IN_HOUR = 60
    init {
        fromDateString = LocalDate.now()
        with(toDate){ toDateString = LocalDate.parse(parsedDate(day,month,year)) }
        initialization()
    }

    constructor(fromDate:DateValue,toDate: DateValue) : this(toDate) {
        with(fromDate){fromDateString = LocalDate.parse (parsedDate(day,month, year))}
        with(toDate){toDateString = LocalDate.parse (parsedDate(day,month, year))}
        initialization()
    }

    private fun initialization(){
        daysBetween = Days.daysBetween(fromDateString,toDateString).days
        months = Months.monthsBetween(fromDateString,toDateString).months
        weeks = Math.abs(daysBetween!!) /DAYS_IN_WEEK
        days = Math.abs(daysBetween!!)
        hours = days*HOURS_IN_DAY
        minutes = hours*MINUTES_IN_HOUR
    }

    private fun parsedDate(day:Int,month:Int,year:Int):String{
        return "$year-$month-$day"
    }

    fun getMonthsNumber():Int{
        return Math.abs((Months.monthsBetween(fromDateString,toDateString).months)%12)
    }

    fun getDaysNumber():Int{
        return dDays(daysBetween!!)
    }

    fun getYearsNumber():Int{
        return Math.abs(Years.yearsBetween(fromDateString,toDateString).years)
    }


    private fun dDays(days: Int): Int{
        if (days>0){
            if (toDateString?.dayOfMonth!!>=fromDateString?.dayOfMonth!!){
                return toDateString!!.dayOfMonth - fromDateString!!.dayOfMonth
            }
            return toDateString!!.minusMonths(1).dayOfMonth().maximumValue - fromDateString!!.dayOfMonth + toDateString!!.dayOfMonth
        }
        else if (toDateString?.dayOfMonth!!<=fromDateString?.dayOfMonth!!){
                return fromDateString!!.dayOfMonth-toDateString!!.dayOfMonth
        }
        return fromDateString!!.minusMonths(1).dayOfMonth().maximumValue - toDateString!!.dayOfMonth +fromDateString!!.dayOfMonth
    }
}