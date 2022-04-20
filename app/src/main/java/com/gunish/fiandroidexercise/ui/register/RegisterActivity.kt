package com.gunish.fiandroidexercise.ui.register

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.gunish.fiandroidexercise.data.Resource
import com.gunish.fiandroidexercise.databinding.ActivityMainBinding
import com.gunish.fiandroidexercise.ui.base.BaseActivity
import com.gunish.fiandroidexercise.utils.SingleEvent
import com.gunish.fiandroidexercise.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterActivity : BaseActivity() {


    private val registerViewModel: RegisterViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initListeners()
        collectFlow()

    }


    private fun initListeners() {
        binding.dayValue.addTextChangedListener {
            registerViewModel.setDay(it.toString())
        }
        binding.monthValue.addTextChangedListener {
            registerViewModel.setMonth(it.toString())
        }
        binding.yearValue.addTextChangedListener {
            registerViewModel.setYear(it.toString())
        }
        binding.panValue.addTextChangedListener {
            registerViewModel.setPan(it.toString())
        }

        binding.nextButton.setOnClickListener {
            registerViewModel.register(
                binding.panValue.toString(),
                binding.dayValue.toString().toInt(),
                binding.monthValue.toString().toInt(),
                binding.yearValue.toString().toInt()
            )
        }

        binding.noPanButton.setOnClickListener {
            finish()
        }

    }


    override fun observeViewModel() {

        registerViewModel.registerLiveData.observe(this) { status ->
            when (status) {
                is Resource.Success -> status.data?.let { response ->
                    response.message?.let { message -> registerViewModel.showToastMessage(message)
                    }
                }
                is Resource.DataError -> {
                    status.errorMessage?.let {
                        registerViewModel.showToastMessage(it)
                    }
                }
            }
        }



        observeToast(registerViewModel.showToast)


    }

    private fun collectFlow() {
        lifecycleScope.launch {
            registerViewModel.isSubmitEnabled.collect { value ->
                binding.nextButton.isEnabled = value
            }
        }
    }


    private fun observeToast(event: LiveData<SingleEvent<Any>>) {
        binding.root.showToast(this, event, Snackbar.LENGTH_LONG)
    }


}

