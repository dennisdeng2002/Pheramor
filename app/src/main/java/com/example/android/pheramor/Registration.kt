package com.example.android.pheramor

import android.net.Uri

data class Registration(
        var email: String = "",
        var password: String = "",
        var name: String = "",
        var zipcode: String = "",
        var height: String = "",
        var gender: String = "",
        var dob: String = "",
        var preferredGender: String = "",
        var preferredAgeRangeMin: Float = 0f,
        var preferredAgeRangeMax: Float = 0f,
        var race: String = "",
        var religion: String = "",
        var profilePictureUri: Uri? = null
)
