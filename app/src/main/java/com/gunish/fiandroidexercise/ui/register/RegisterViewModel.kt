package com.gunish.fiandroidexercise.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.gunish.fiandroidexercise.data.Resource
import com.gunish.fiandroidexercise.data.dto.register.RegisterResponse
import com.gunish.fiandroidexercise.data.repository.Repository
import com.gunish.fiandroidexercise.data.repository.RepositoryImp
import com.gunish.fiandroidexercise.ui.base.BaseViewModel
import com.gunish.fiandroidexercise.utils.InputFilterMinMax
import com.gunish.fiandroidexercise.utils.PanValidator
import com.gunish.fiandroidexercise.utils.SingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.*
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository:RepositoryImp):BaseViewModel() {


    private val _showToast=MutableLiveData<SingleEvent<Any>>()
    val showToast:LiveData<SingleEvent<Any>> get() = _showToast

    private val _registerLiveData = MutableLiveData<Resource<RegisterResponse>>()
    val registerLiveData: LiveData<Resource<RegisterResponse>> get() = _registerLiveData


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



}