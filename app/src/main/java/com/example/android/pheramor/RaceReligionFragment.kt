package com.example.android.pheramor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_race_religion.*

class RaceReligionFragment : BaseFragment() {

    var race: String = ""
    var religion: String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        layoutId = R.layout.fragment_race_religion
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun setup() {
        val races = arrayOf("", "American Indian", "African American", "Asian", "Hispanic", "White")
        race_spinner.adapter = ArrayAdapter<String>(activity!!, R.layout.spinner_list_item, races)
        race_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {}

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                race = races[p2]
            }

        }

        val religions = arrayOf("", "Christianity", "Islam", "Nonreligious", "Hinduism", "Buddhism")
        religion_spinner.adapter = ArrayAdapter<String>(activity!!, R.layout.spinner_list_item, religions)
        religion_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {}

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                religion = religions[p2]
            }
        }
    }

    override fun isValid(): Boolean {
        registrationService.registration.race = race
        registrationService.registration.religion = religion
        return super.isValid()
    }

}
