package com.sr.sample.retrofit

import io.reactivex.disposables.Disposable

class APITask : BaseAPITask() {

    private val apiCall: APICall = Retrofit.getRetrofit().create(APICall::class.java)

    companion object Singleton{
        fun getInstance(): APITask {
            return APITask()
        }
    }


    fun doGetPost(listener: OnResponseListener): Disposable {
        return getRequest(apiCall.doGetPosts(), listener, 1) as Disposable

    }
}