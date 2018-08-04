package com.example.android.pheramor

import io.reactivex.Maybe
import retrofit2.http.Body
import retrofit2.http.POST

interface PheramorApi {
    @POST(".")
    fun register(@Body registration: Registration): Maybe<Any>
}
