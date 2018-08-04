package com.example.android.pheramor

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import kotlinx.android.synthetic.main.fragment_gender_dob.*

class GenderDOBFragment : BaseFragment(), DatePickerDialog.OnDateSetListener {

    private var gender: String = "Male"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        layoutId = R.layout.fragment_gender_dob
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun setup() {
        preferred_gender_radio_group.setOnCheckedChangeListener { _, i ->
            gender = if (i == R.id.radio_button_male) "Male" else "Female"
        }

        dob_edit_text.setOnClickListener {
            val (month, day, year) = dob_edit_text.text.toString().split("/")
            DatePickerDialog(activity!!, this, year.toInt(), month.toInt() - 1, day.toInt()).show()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onDateSet(datePicker: DatePicker?, year: Int, month: Int, day: Int) {
        val displayMonth = month + 1
        dob_edit_text.setText("$displayMonth/$day/$year")
    }

    override fun isValid(): Boolean {
        registrationService.registration.gender = gender
        registrationService.registration.dob = dob_edit_text.text.toString()
        return super.isValid()
    }

}
