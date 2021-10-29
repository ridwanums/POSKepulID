package com.example.ambarrukmo.dialog

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import com.example.ambarrukmo.api.AppConstants
import java.text.SimpleDateFormat
import java.util.*

class TimePickerFragmentDialog() : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    var onClick: ((String) -> Unit?)? = null
    private var defaulTime : String = ""

    fun setDefaultTime(date: String){
        this.defaulTime = date
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var c = Calendar.getInstance()
        var hour : Int = 0
        var minute : Int = 0
        if (defaulTime.isEmpty()){
            hour = c.get(Calendar.HOUR)
            minute = c.get(Calendar.MINUTE)
        } else {
            val format = SimpleDateFormat(AppConstants.DATE_FORMAT_HOUR, Locale.US)
            val date = format.parse(defaulTime)
            c.time = date
            hour = c.get(Calendar.HOUR)
            minute = c.get(Calendar.MINUTE)
        }
        return TimePickerDialog(requireContext(), this, hour, minute, true)
    }


    override fun onTimeSet(view: TimePicker?, hour: Int, minute: Int) {
        val date = "$hour:$minute"
        onClick?.invoke(date)
    }
}