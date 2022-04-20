package com.gunish.fiandroidexercise.utils

import android.util.Log
import java.time.DateTimeException
import java.time.LocalDate

object DateUtils {
    fun isDateCorrect(day: String, month: String, year: String): Boolean {
        if (NumberUtils.safeInt(year, 0) >= 1900) {

            try {
                val date =
                    LocalDate.of(
                        NumberUtils.safeInt(year, 0),
                        NumberUtils.safeInt(month, 0),
                        NumberUtils.safeInt(day, 0)
                    )
                Log.d("Data", date.toString())
            } catch (dateTimeException: DateTimeException) {
                return false
            }
            return true

        }
        return false
    }

}