package com.leon.homework.ui.adapter

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputEditText

@BindingAdapter("app:errorText")
fun errorText(view: TextInputEditText, errorMsg: String) {
    if (errorMsg.isNotEmpty()) {
        view.error = errorMsg
    }
}