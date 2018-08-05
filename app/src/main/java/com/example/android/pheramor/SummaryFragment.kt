package com.example.android.pheramor

import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_profile_picture.*
import kotlinx.android.synthetic.main.fragment_summary.*

class SummaryFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        layoutId = R.layout.fragment_summary
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun setup() {
        if (registrationService.profilePicture != null) {
            summary_profile_picture_image_view.setImageBitmap(registrationService.profilePicture)
        }

        val registration = registrationService.registration
        summary_name_text_view.text = String.format(getString(R.string.summary_name, registration.name))
        summary_gender_text_view.text = String.format(getString(R.string.summary_gender, registration.gender))
        summary_dob_text_view.text = String.format(getString(R.string.summary_dob, registration.dob))
        summary_height_text_view.text = String.format(getString(R.string.summary_height, registration.height))
        summary_preferred_gender_text_view.text = String.format(getString(R.string.summary_preferred_gender, registration.preferredGender))
        summary_preferred_age_range_text_view.text = String.format(getString(R.string.summary_preferred_age_range, registration.preferredAgeRangeMin, registration.preferredAgeRangeMax))

        if (registration.race.isNotEmpty()) {
            summary_race_text_view.visibility = View.VISIBLE
            summary_race_text_view.text = String.format(getString(R.string.summary_race, registration.race))
        } else {
            summary_race_text_view.visibility = View.INVISIBLE
        }

        if (registration.religion.isNotEmpty()) {
            summary_religion_text_view.visibility = View.VISIBLE
            summary_religion_text_view.text = String.format(getString(R.string.summary_religion, registration.religion))
        } else {
            summary_religion_text_view.visibility = View.INVISIBLE
        }

        signup_button.setOnClickListener { _ ->
            registrationService.register()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Toast.makeText(activity!!, "Success", Toast.LENGTH_SHORT).show()
                    }, { error ->
                        error.printStackTrace()
                        Toast.makeText(activity!!, "Error", Toast.LENGTH_SHORT).show()
                    })
        }
    }

}
