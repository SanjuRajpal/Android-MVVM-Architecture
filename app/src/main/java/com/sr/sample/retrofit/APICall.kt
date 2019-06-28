package com.sr.sample.retrofit

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET

interface APICall {

    @GET(API.POSTS)
    fun doGetPosts(): Observable<ResponseBody>
}