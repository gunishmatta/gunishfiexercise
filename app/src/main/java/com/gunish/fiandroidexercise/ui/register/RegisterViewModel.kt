package com.gunish.fiandroidexercise.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gunish.fiandroidexercise.data.Resource
import com.gunish.fiandroidexercise.data.dto.register.RegisterResponse
import com.gunish.fiandroidexercise.data.repository.RepositoryImp
import com.gunish.fiandroidexercise.ui.base.BaseViewModel
import com.gunish.fiandroidexercise.utils.DateUtils
import com.gunish.fiandroidexercise.utils.PanValidator
import com.gunish.fiandroidexercise.utils.SingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository:RepositoryImp):BaseViewModel() {


    private val _showToast=MutableLiveData<SingleEvent<Any>>()
    val showToast:LiveData<SingleEvent<Any>> get() = _showToast

    private val _registerLiveData = MutableLiveData<Resource<RegisterResponse>>()
    val registerLiveData: LiveData<Resource<RegisterResponse>> get() = _registerLiveData

    private val _pan = MutableStateFlow("")
    private val  _day= MutableStateFlow("")
    private val _month = MutableStateFlow("")
    private val _year = MutableStateFlow("")


    fun setPan(pan:String)
    {
        _pan.value=pan
    }

    fun setDay(day:String)
    {
        _day.value=day
    }

    fun setMonth(month:String)
    {
        _month.value=month
    }

    fun setYear(year:String)
    {
        _year.value=year
    }


    fun register(panNumber:String,day:Int,month:Int,year:Int)
    {
        viewModelScope.launch {
        repository.register().collect {
            _registerLiveData.value=it
        }
        }
    }

    fun showToastMessage(message: String) {
        _showToast.value = SingleEvent(message)
    }

    val isSubmitEnabled: Flow<Boolean> = combine(_pan, _day,_month,_year) { pan, day, month, year ->
        return@combine PanValidator.isValidPan(pan) and DateUtils.isDateCorrect(day,month, year)
    }


}