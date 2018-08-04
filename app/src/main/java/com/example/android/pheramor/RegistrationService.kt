package com.example.android.pheramor

import android.graphics.Bitmap
import com.google.gson.GsonBuilder
import io.reactivex.Maybe
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RegistrationService() {

    private var pheramorApi: PheramorApi

    init {
        val gson = GsonBuilder().setLenient().create()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://external.dev.pheramor.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        pheramorApi = retrofit.create(PheramorApi::class.java)
    }

    var registration: Registration = Registration()
    var profilePicture: Bitmap? = null

    fun register(): Maybe<Any> {
        return pheramorApi.register(registration)
    }

    companion object {

        private var registrationService: RegistrationService? = null

        fun getInstance(): RegistrationService {
            if (registrationService == null) registrationService = RegistrationService()
            return registrationService!!
        }

    }

}
