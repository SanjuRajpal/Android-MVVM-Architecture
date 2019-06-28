package com.sr.sample.retrofit


interface OnResponseListener {

    fun onResponseReceived(response: Any, requestCode: Int)

    fun onResponseError(message: String, requestCode: Int)

    fun onTokenExpires()
}
