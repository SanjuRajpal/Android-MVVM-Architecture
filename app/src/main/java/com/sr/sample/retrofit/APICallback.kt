package com.sr.sample.retrofit

import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.sr.sample.R
import com.sr.sample.ui.App
import io.reactivex.observers.DisposableObserver
import okhttp3.ResponseBody

class APICallback<T>(private val mListener: OnResponseListener, private val requestCode: Int) :
    DisposableObserver<T>() {

    override fun onComplete() {

    }

    override fun onNext(response: T) {
        try {
            val json = (response as ResponseBody).string()
//            val jsonObjects = Gson().fromJson(json, JsonObject::class.java)
            mListener.onResponseReceived(json, requestCode)


        } catch (e: Exception) {
            e.printStackTrace()
            mListener.onResponseError(e.message!!, requestCode)
        }
    }

    override fun onError(e: Throwable) {
        if (e is java.net.ConnectException) {
            mListener.onResponseError(App.getInstance().getString(R.string.e_no_internet), requestCode)
        } else if (!TextUtils.isEmpty(e.message))
            mListener.onResponseError(e.message!!, requestCode)
        else
            mListener.onResponseError("Something went wrong, Please try later", requestCode)
    }


}