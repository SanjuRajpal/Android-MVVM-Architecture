package com.sr.sample.retrofit

import android.content.Context
import com.sr.sample.R
import com.sr.sample.ui.App
import com.sr.sample.utility.NetworkUtil
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody

open class BaseAPITask {

    private fun isInternetAvailable(context: Context): Boolean {
        return NetworkUtil.isNetworkAvailable(context)
    }

    private fun noInternetError(context: Context): String {
        return context.resources.getString(R.string.e_no_internet)
    }


    protected fun getRequest(
        request: Observable<ResponseBody>,
        mListener: OnResponseListener,
        requestCode: Int
    ): DisposableObserver<*>? {
        return if (isInternetAvailable(App.getInstance())) {
            request.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(APICallback(mListener, requestCode))
        } else {
            mListener.onResponseError(noInternetError(App.getInstance()), requestCode)
            null
        }

    }

}