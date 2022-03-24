package com.gunish.fiandroidexercise.data.error

import java.lang.Exception

class Error(val code:Int,val description:String) {
    constructor(exception: Exception):this(code=DEFAULT_ERROR,description=exception.message?:"Something wrong happened")
}

const val DEFAULT_ERROR=-1
const val PAN_INPUT_ERROR=-2
const val BIRTHDATE_INPUT_ERROR=-3
