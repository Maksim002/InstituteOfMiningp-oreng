package com.example.instituteofmining.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

object MyUtils {
    fun hideKeyboard(activity: Activity, view: View) {
        // скрывает клавиатуру
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}