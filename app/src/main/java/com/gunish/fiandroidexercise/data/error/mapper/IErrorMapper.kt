package com.gunish.fiandroidexercise.data.error.mapper

interface IErrorMapper {
    fun getErrorString(errorId:Int):String
    val errorsMap:Map<Int,String>
}