package com.codelabs.poskepulid.helper

import android.widget.EditText
import android.text.TextWatcher
import android.text.Editable
import android.view.KeyEvent
import android.view.View

object EditTextUtils {
    fun getTextWatcher(et: EditText, next_focus: EditText?, is_last: Boolean): TextWatcher {
        return object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.length > 0) {
                    if (!is_last) et.clearFocus()
                    if (next_focus != null) {
                        next_focus.requestFocus()
                        next_focus.isCursorVisible = true
                    }
                }
            }
        }
    }

    fun onClickDelete(pref_focus: EditText?, et: EditText, is_first: Boolean): View.OnKeyListener {
        return View.OnKeyListener { v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                if (!is_first && et.text.toString().length == 0) et.clearFocus()
                if (pref_focus != null && et.text.toString().length == 0) {
                    pref_focus.requestFocus()
                    pref_focus.isCursorVisible = true
                }
            }
            false
        }
    }
}