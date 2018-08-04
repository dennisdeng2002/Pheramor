package com.example.android.pheramor

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

open class BaseFragment : Fragment() {

    lateinit var registrationService: RegistrationService
    private lateinit var containerView: View

    override fun getView(): View? {
        return containerView
    }

    var layoutId: Int = R.layout.fragment_email_password

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registrationService = RegistrationService.getInstance()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        containerView = inflater.inflate(layoutId, container, false)
        setup()
        return containerView
    }

    open fun setup() {}

    open fun isValid(): Boolean {
        return true
    }

}
