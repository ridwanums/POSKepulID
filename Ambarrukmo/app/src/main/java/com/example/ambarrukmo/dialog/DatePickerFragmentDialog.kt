package com.example.ambarrukmo.dialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.example.ambarrukmo.api.AppConstants
import java.text.SimpleDateFormat
import java.util.*

class DatePickerFragmentDialog() : DialogFragment(), DatePickerDialog.OnDateSetListener {
    var onClick: ((String) -> Unit?)? = null
    private var defaultDate: String = ""

    fun setDefaultDate(date: String) {
        this.defaultDate = date
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var c = Calendar.getInstance()
        var year: Int = 0
        var month: Int = 0
        var day: Int = 0
        if (defaultDate.isEmpty()) {
            // Use the current date as the default date in the picker
            year = c.get(Calendar.YEAR)
            month = c.get(Calendar.MONTH)
            day = c.get(Calendar.DAY_OF_MONTH)
        } else {
           val format = SimpleDateFormat(AppConstants.DATE_FORMAT_EVENT_SCHEDULE,Locale.US)
            val date = format.parse(defaultDate)
            c.time = date
            year = c.get(Calendar.YEAR)
            month = c.get(Calendar.MONTH)
            day = c.get(Calendar.DAY_OF_MONTH)

        }

        // Create a new instance of DatePickerDialog and return it
        return DatePickerDialog(requireActivity(), this, year, month, day)
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        val monthReal = month + 1
        val date = "$day-$monthReal-$year"
        onClick?.invoke(date)
        // Do something with the date chosen by the user


    }
}