package com.example.android.pheramor

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_name_zipcode_height.*

class NameZipcodeHeightFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        layoutId = R.layout.fragment_name_zipcode_height
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun isValid(): Boolean {
        val name = full_name_text_input_edit_text.text.toString()
        val validName = !TextUtils.isEmpty(name)
        if (!validName) full_name_text_input_layout.error = "Name cannot be empty"
        else full_name_text_input_layout.error = null

        val zipcode = zipcode_text_input_edit_text.text.toString()
        val validZipcode = !TextUtils.isEmpty(zipcode)
        if (!validZipcode) zipcode_text_input_layout.error = "Zipcode cannot be empty"
        else zipcode_text_input_layout.error = null

        val height = height_text_input_edit_text.text.toString()
        val validHeight = !TextUtils.isEmpty(height)
        if (!validHeight) height_text_input_layout.error = "Height cannot be empty"
        else height_text_input_layout.error = null

        val isValid = validName && validZipcode && validHeight
        if (isValid) {
            registrationService.registration.name = name
            registrationService.registration.zipcode = zipcode
            registrationService.registration.height = height
        }

        return isValid
    }

}
