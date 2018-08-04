package com.example.android.pheramor

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_email_password.*

class EmailPasswordFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        layoutId = R.layout.fragment_email_password
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun isValid(): Boolean {
        val email = email_address_text_input_edit_text.text.toString()
        val validEmail = !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
        if (!validEmail) email_address_text_input_layout.error = "Invalid Email"
        else email_address_text_input_layout.error = null

        val password = password_text_input_edit_text.text.toString()
        val validPassword = !TextUtils.isEmpty(password)
        if (!validPassword) password_text_input_layout.error = "Password cannot be empty"
        else password_text_input_layout.error = null

        val isValid = validEmail && validPassword
        if (isValid) {
            registrationService.registration.email = email
            registrationService.registration.password = password
        }

        return isValid
    }

}
