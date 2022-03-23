package com.gunish.fiandroidexercise.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gunish.fiandroidexercise.ui.base.BaseViewModel
import com.gunish.fiandroidexercise.utils.InputFilterMinMax
import com.gunish.fiandroidexercise.utils.PanValidator
import com.gunish.fiandroidexercise.utils.SingleEvent
import java.time.LocalDate
import java.util.*

class RegisterViewModel:BaseViewModel() {


    private val _showToast=MutableLiveData<SingleEvent<Any>>()
    val showToast:LiveData<SingleEvent<Any>> get() = _showToast




    fun register(panNumber:String,day:Int,month:Int,year:Int)
    {
        val isPanNumberValid=PanValidator.isValidPan(panNumber)

    }






}