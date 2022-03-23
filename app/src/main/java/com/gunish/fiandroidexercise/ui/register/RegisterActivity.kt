package com.gunish.fiandroidexercise.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.activity.viewModels
import androidx.compose.runtime.snapshots.Snapshot.Companion.observe
import com.gunish.fiandroidexercise.databinding.ActivityMainBinding
import com.gunish.fiandroidexercise.ui.base.BaseActivity
import com.gunish.fiandroidexercise.utils.InputFilterMinMax
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
        setEditTextFilters()
    }


    private fun setEditTextFilters()
    {
        binding.monthValue.filters=arrayOf(InputFilterMinMax(1, 12))

        binding.yearValue.filters= arrayOf(InputFilterMinMax(1900,2020))

        when(binding.monthValue.text.toInt())
        {
            2-> if (binding.yearValue.text.toInt()%4==0)
            {
                binding.dayValue.filters = arrayOf(InputFilterMinMax(1, 29))
            }
            else{
                binding.dayValue.filters = arrayOf(InputFilterMinMax(1, 28))
            }
            1 or 3 or 5 or 7 or 8 or 10 -> binding.dayValue.filters = arrayOf(InputFilterMinMax(1, 31))

            else->binding.dayValue.filters = arrayOf(InputFilterMinMax(1, 31))

        }


    }

    override fun observeViewModel() {

    }




}

private fun Editable.toInt(): Int {
   return this.toString().toIntOrNull() ?: 0
}
