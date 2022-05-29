package com.leon.homework.ui.adapter

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatSpinner
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

@BindingAdapter("app:setList")
fun setSpinnerList(spinner: AppCompatSpinner, list: List<String>) {
    val adapter = ArrayAdapter(
        spinner.context,
        android.R.layout.simple_spinner_item,
        list
    )
    spinner.adapter = adapter
}

@BindingAdapter("app:selectionPosition")
fun setSpinnerSelectionPosition(spinner: AppCompatSpinner, position: Int) {
    spinner.setSelection(position)
}

@InverseBindingAdapter(attribute = "selectionPosition")
fun getSpinnerSelectionPosition(spinner: AppCompatSpinner): Int {
    return spinner.selectedItemPosition
}

@BindingAdapter("selectionPositionAttrChanged")
fun setSpinnerOnChangeListener(spinner: AppCompatSpinner, spinnerAttrChanged: InverseBindingListener) {
    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            spinnerAttrChanged.onChange()
        }

        override fun onNothingSelected(parent: AdapterView<*>?) {

        }
    }
}