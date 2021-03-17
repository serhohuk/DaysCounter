package com.sign.bottomnavtest


data class DateValue(val day:Int, val month:Int, val year:Int) {
    override fun toString(): String {
        return "$day-$month-$year"
    }
}