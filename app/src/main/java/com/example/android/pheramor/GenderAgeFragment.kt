package com.example.android.pheramor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jaygoo.widget.OnRangeChangedListener
import com.jaygoo.widget.RangeSeekBar
import kotlinx.android.synthetic.main.fragment_gender_age.*

class GenderAgeFragment : BaseFragment() {

    private var preferredGender: String = "Male"
    private var preferredAgeRangeMin: Float = 18f
    private var preferredAgeRangeMax: Float = 30f

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        layoutId = R.layout.fragment_gender_age
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun setup() {
        gender_radio_group.setOnCheckedChangeListener { _, i ->
            preferredGender = if (i == R.id.radio_button_male) "Male" else "Female"
        }

        age_range_seek_bar.setValue(preferredAgeRangeMin, preferredAgeRangeMax)
        preferred_age_range_label.text = getString(R.string.preferred_age_range_label, preferredAgeRangeMin, preferredAgeRangeMax)
        age_range_seek_bar.setOnRangeChangedListener(object : OnRangeChangedListener {
            override fun onStartTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {}

            override fun onRangeChanged(view: RangeSeekBar?, leftValue: Float, rightValue: Float, isFromUser: Boolean) {
                preferred_age_range_label.text = String.format(getString(R.string.preferred_age_range_label), leftValue, rightValue)
            }

            override fun onStopTrackingTouch(view: RangeSeekBar?, isLeft: Boolean) {}
        })
    }

    override fun isValid(): Boolean {
        registrationService.registration.preferredGender = preferredGender
        registrationService.registration.preferredAgeRangeMin = preferredAgeRangeMin
        registrationService.registration.preferredAgeRangeMax = preferredAgeRangeMax
        return super.isValid()
    }

}
