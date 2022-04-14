package com.gunish.fiandroidexercise.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.activity.viewModels
import androidx.compose.runtime.snapshots.Snapshot.Companion.observe
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.gunish.fiandroidexercise.data.Resource
import com.gunish.fiandroidexercise.databinding.ActivityMainBinding
import com.gunish.fiandroidexercise.ui.base.BaseActivity
import com.gunish.fiandroidexercise.utils.InputFilterMinMax
import com.gunish.fiandroidexercise.utils.SingleEvent
import com.gunish.fiandroidexercise.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterActivity : BaseActivity() {


   private val registerViewModel:RegisterViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun initViewBinding() {
        binding= ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        binding.nextButton.setOnClickListener {
            registerViewModel.register("DYWPM",20,1,2007)
        }
    }




    override fun observeViewModel() {

        registerViewModel.registerLiveData.observe(this, Observer {
            status->
            when(status)
            {
                is Resource.Success->status.data?.let {response->
                    response.message?.let { message -> registerViewModel.showToastMessage(message) }
                }
                is Resource.DataError->{
                    status.errorMessage?.let {
                        registerViewModel.showToastMessage(it)
                    }
                }
            }
        })

        observeToast(registerViewModel.showToast)



    }

    private fun observeToast(event: LiveData<SingleEvent<Any>>) {
        binding.root.showToast(this, event, Snackbar.LENGTH_LONG)
    }


}

