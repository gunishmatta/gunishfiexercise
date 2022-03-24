package com.gunish.fiandroidexercise.data.error.mapper

import android.content.Context
import com.gunish.fiandroidexercise.R
import com.gunish.fiandroidexercise.data.error.BIRTHDATE_INPUT_ERROR
import com.gunish.fiandroidexercise.data.error.PAN_INPUT_ERROR
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ErrorMapper @Inject constructor(@ApplicationContext val context: Context):IErrorMapper {

    override fun getErrorString(errorId: Int): String {
        return context.getString(errorId)
    }

    override val errorsMap: Map<Int, String>
        get() = mapOf(Pair(PAN_INPUT_ERROR,getErrorString(R.string.pan_input_error)),
                Pair(BIRTHDATE_INPUT_ERROR,getErrorString(R.string.birthdate_input_error))
            )


}