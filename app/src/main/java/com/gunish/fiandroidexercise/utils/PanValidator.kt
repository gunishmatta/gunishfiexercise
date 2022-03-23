package com.gunish.fiandroidexercise.utils

import java.util.regex.Matcher
import java.util.regex.Pattern

object PanValidator {
    fun isValidPan(pan: String?): Boolean {
        val mPattern: Pattern = Pattern.compile("[A-Z]{5}[0-9]{4}[A-Z]{1}")
        val mMatcher: Matcher = mPattern.matcher(pan)
        return mMatcher.matches()
    }
}